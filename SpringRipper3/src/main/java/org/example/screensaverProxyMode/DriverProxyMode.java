package org.example.screensaverProxyMode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DriverProxyMode {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigProxyMode.class);

        while (true) {
            context.getBean(ColorFrameProxyMode.class).showOnRandomPlace();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
