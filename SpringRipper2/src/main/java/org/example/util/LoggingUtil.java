package org.example.util;

import org.slf4j.Logger;

import java.lang.reflect.Method;

public class LoggingUtil {

    public static void logMethodOperation(Logger log, String beanName, Method method, String operation){

        log.info("Bean " + "[" + beanName + "]" + " enters method " + new Object(){}.getClass().getEnclosingMethod().getName());

    }


}
