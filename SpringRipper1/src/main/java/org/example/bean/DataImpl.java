package org.example.bean;

import org.example.annotations.Profiling;

@Profiling
public class DataImpl implements Data {
    @Override
    public void printData() {
        System.out.println("Printing data");
    }
}
