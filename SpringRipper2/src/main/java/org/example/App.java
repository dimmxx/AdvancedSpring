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

        log.info("----------------------------------- before bean creation ------------------------");
        Quoter obj = context.getBean(Quoter.class);
        log.info("----------------------------------- after bean creation -------------------------");
        obj.sayQuote();

        log.info("EXIT");
    }
}
