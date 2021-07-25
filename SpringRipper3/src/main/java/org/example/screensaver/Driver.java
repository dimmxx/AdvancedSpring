package org.example.screensaver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        while (true) {
            context.getBean(ColorFrame.class).showOnRandomPlace();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
