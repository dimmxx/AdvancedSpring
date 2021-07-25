package org.example;

import org.example.bean.Quoter;
import org.example.bean.QuoterImpl;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class PropertiesFileApplicationContext extends GenericApplicationContext {

    public PropertiesFileApplicationContext (String fileName) {
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(this);
        int i = reader.loadBeanDefinitions(fileName);
        System.out.println("Found " + i + " beans");
        refresh();
    }

    public static void main(String[] args) {
        PropertiesFileApplicationContext context = new PropertiesFileApplicationContext("context.properties");
        context.getBean(Quoter.class).sayQuote();
    }

}
