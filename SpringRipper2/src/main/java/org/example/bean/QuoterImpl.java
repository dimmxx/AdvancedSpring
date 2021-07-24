package org.example.bean;

import org.example.annotations.DeprecatedClass;
import org.example.annotations.InjectRandomInt;

@DeprecatedClass (newImpl = NewQuoterImpl.class)
public class QuoterImpl implements Quoter {

    @InjectRandomInt(min = 1, max = 3)
    private int repeat;
    private String message;

    public QuoterImpl() {
        System.out.println(">>>>> Phase1: repeat = " + repeat + " - срабатывает, когда Спринг создает бин с помощью рефлексии");
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
