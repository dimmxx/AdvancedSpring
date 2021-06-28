package org.example.bean;

import org.example.annotations.InjectRandomInt;
import org.example.annotations.PostProxy;
import org.example.annotations.Profiling;

import javax.annotation.PostConstruct;

@Profiling
public class QuoterImpl implements Quoter {

    @InjectRandomInt(min = 1, max = 3)
    private int repeat;
    private String message;

    public QuoterImpl() {
        System.out.println("Phase1: repeat = " + repeat);
    }

    @PostConstruct
    public void init() {
        System.out.println("Phase2: repeat = " + repeat);
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("Random is: " + repeat);
        for(int i = 0; i < repeat; i++){
            System.out.println(">>>>>Message: " + message);
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
