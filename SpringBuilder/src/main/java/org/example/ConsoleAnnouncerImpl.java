package org.example;

public class ConsoleAnnouncerImpl implements Announcer {
    @Override
    public void announce(String message) {
        System.out.println(message);
    }
}
