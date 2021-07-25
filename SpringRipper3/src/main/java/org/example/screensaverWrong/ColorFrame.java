package org.example.screensaverWrong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Component
//@Scope("prototype")
public class ColorFrame extends JFrame {

    @Autowired
    ApplicationContext context;

    public ColorFrame() {
       setSize(300, 300);
       setVisible(true);
       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1200), random.nextInt(700));
        getContentPane().setBackground(context.getBean(Color.class));
        repaint();

    }
}
