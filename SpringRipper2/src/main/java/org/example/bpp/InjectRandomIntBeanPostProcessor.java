package org.example.bpp;

import lombok.extern.slf4j.Slf4j;
import org.example.annotations.InjectRandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("Bean " + "[" + beanName + "]" + " enters method " + new Object(){}.getClass().getEnclosingMethod().getName());
        Field[] fields = bean.getClass().getDeclaredFields();
        for(Field field : fields){
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if(annotation != null){
                int min = annotation.min();
                int max = annotation.max();
                int value = ThreadLocalRandom.current().nextInt(min, max + 1);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, value);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("Bean " + "[" + beanName + "]" + " enters method " + new Object(){}.getClass().getEnclosingMethod().getName());
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
