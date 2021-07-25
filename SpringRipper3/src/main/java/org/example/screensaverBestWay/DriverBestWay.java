package org.example.screensaverBestWay;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DriverBestWay {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigBestWay.class);

        while (true) {
            context.getBean(ColorFrameBestWay.class).showOnRandomPlace();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
