package org.example.screensaverBestWay;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "org.example.screensaverBestWay")
public class ConfigBestWay {

    @Bean
    @Scope(value = "prototype")
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Bean
    public ColorFrameBestWay colorFrameBestWay() {
        return new ColorFrameBestWay() {
            @Override
            protected Color getColor() {
                return color(); //it is not method - it is application to the bean Color
            }
        };
    }


}
