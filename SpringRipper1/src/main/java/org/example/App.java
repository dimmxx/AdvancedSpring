package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.bean.Quoter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@Slf4j
public class App {

    public static void main(String[] args) {
        log.info("Before context load in main");
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        Arrays.stream(context.getBeanDefinitionNames()).forEach(b -> log.info("BEAN: " + b));

//        while (true){
//            Quoter obj = context.getBean(Quoter.class);
//            obj.sayQuote();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//
//        }

        log.info("----------------------------------- before bean creation ------------------------");
        Quoter obj = context.getBean(Quoter.class);
        log.info("----------------------------------- after bean creation -------------------------");
        obj.sayQuote();

//        int i = 1;
//        System.out.println("\nBeans in the Spring container:" );
//        for(String beanName : context.getBeanDefinitionNames()){
//            System.out.println(i + ". Bean: " + beanName);
//            i++;
//        }
//        System.out.println("Total beans: " + i + "\n");

//        Map<String, Object> map = context.getBeansOfType(Object.class);
//        map.forEach((k, v) -> {
//            if(v instanceof BeanPostProcessor |
//                Arrays.asList(v.getClass().getInterfaces()).contains(BeanPostProcessor.class)
//            ){
//                System.out.print(">>>> BeanPostProcessor: ");
//            }
//            System.out.println(k + " :" + v);
//        });
        log.info("EXIT");
    }
}
