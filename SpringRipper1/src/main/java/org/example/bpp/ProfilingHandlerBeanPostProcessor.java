package org.example.bpp;

import lombok.extern.slf4j.Slf4j;
import org.example.annotations.Profiling;
import org.example.controller.ProfilingController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {

    private final Map<String, Class<?>> beanMap = new HashMap<>();

    private final ProfilingController profilingController = new ProfilingController();

    public ProfilingHandlerBeanPostProcessor() {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        try {
            mBeanServer.registerMBean(profilingController, new ObjectName("profiling", "name", "controller"));
        } catch (InstanceAlreadyExistsException | MBeanRegistrationException | MalformedObjectNameException | NotCompliantMBeanException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("Bean " + beanName + " enters method " + new Object(){}.getClass().getEnclosingMethod().getName());
        Class<?> clazz = bean.getClass();
        if (clazz.isAnnotationPresent(Profiling.class)) {
            beanMap.put(beanName, bean.getClass());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("Bean " + beanName + " enters method " + new Object(){}.getClass().getEnclosingMethod().getName());
        Class<?> beanClass = beanMap.get(beanName);
        if (beanClass != null) {
            log.info("Before proxy creation for " + beanClass.getName());
            return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (profilingController.isEnabled()) {
                        System.out.println("\n:::Profiling...");
                        long before = System.nanoTime();
                        Object retVal = method.invoke(bean, args);
                        long after = System.nanoTime();
                        System.out.println(":::Time elapsed: " + (after - before) / 1000 + " ms");
                        System.out.println(":::Finished profiling...");
                        return retVal;
                    } else {
                        return method.invoke(bean, args);
                    }
                }
            });
        } else {
            return bean;
        }
    }
}
