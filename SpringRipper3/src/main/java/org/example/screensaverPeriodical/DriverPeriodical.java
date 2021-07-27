package org.example.screensaverPeriodical;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DriverPeriodical {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigPeriodical.class);

        while (true) {
            context.getBean(ColorFramePeriodical.class).showOnRandomPlace();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
