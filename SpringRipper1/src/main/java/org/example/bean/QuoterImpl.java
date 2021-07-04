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
        System.out.println(">>>>> Phase1: repeat = " + repeat + " - срабатывает, когда Спринг создает бин с помощью рефлексии");
    }

    @PostConstruct
    public void init() {
        System.out.println(">>>>> Phase2: repeat = " + repeat +  " - срабатывает после создания бина и обработки методом BPP: postProcessBeforeInitialization. @PostConstruct работает с оригинальными бинами, не прокси!");
    }

    @PostProxy
    @Override
    public void runPostProxy(){
        System.out.println(">>>>> Phase3: repeat = " + repeat +  " - срабатывает после обработки методом BPP: postProcessAfterInitialization. Работает с прокси!");
    }

    @Override
    public void sayQuote() {
        System.out.println(">>>>> Random = " + repeat + ", message = " + message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
