package org.example;

import org.example.bean.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();

        int i = 1;
        for(String beanName : context.getBeanDefinitionNames()){
            System.out.println(i + ". Bean: " + beanName);
        }




    }

}
