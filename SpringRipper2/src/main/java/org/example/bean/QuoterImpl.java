package org.example.bean;

import org.example.annotations.DeprecatedClass;

@DeprecatedClass(newIpl = QuoterImplV2.class)
public class QuoterImpl implements Quoter {

    @Override
    public void sayQuote() {
        System.out.println("Old version");
    }

}
