package org.example.screensaverWrong;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "org.example.screensaverWrong")
public class Config {

    @Bean
    @Scope(value = "prototype")
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }


}
