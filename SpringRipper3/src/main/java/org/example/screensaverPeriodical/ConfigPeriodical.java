package org.example.screensaverPeriodical;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "org.example.screensaverPeriodical")
public class ConfigPeriodical {

    @Bean
    @Scope(value = "periodical")
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Bean
    public ColorFramePeriodical colorFrameBestWay() {
        return new ColorFramePeriodical() {
            @Override
            protected Color getColor() {
                return color(); //it is not method - it is application to the bean Color
            }
        };
    }


}
