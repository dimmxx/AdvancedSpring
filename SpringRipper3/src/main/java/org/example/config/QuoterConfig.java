package org.example.config;

import org.example.bean.Quoter;
import org.example.bean.QuoterImpl;
import org.example.bpp.InjectRandomIntBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "org.example")
public class QuoterConfig {

    @Bean
    public Quoter quoter() {
        return new QuoterImpl();
    }

    @Bean
    public InjectRandomIntBeanPostProcessor injectRandomIntBeanPostProcessor() {
        return new InjectRandomIntBeanPostProcessor();
    }


}
