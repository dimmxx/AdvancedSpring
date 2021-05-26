package org.example;

import org.example.bean.Quoter;
import org.example.bean.QuoterImpl;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

//        while (true){
//            Quoter obj = context.getBean(Quoter.class);
//            obj.sayQuote();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        Quoter obj = context.getBean(Quoter.class);
        //obj.sayQuote();

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
    }
}
