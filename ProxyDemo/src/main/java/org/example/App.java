package org.example;

import java.lang.reflect.Proxy;

public class App {

    public static void main(String[] args) {

        //Создаем оригинальный объект
        Man vasia = new Man("Вася", 30, "Санкт-Петербург", "Россия");

        vasia.introduce(vasia.getName());
        vasia.sayAge(vasia.getAge());
        vasia.sayFrom(vasia.getCity(), vasia.getCountry());

        //Получаем загрузчик класса у оригинального объекта
        ClassLoader vasiaClassLoader = vasia.getClass().getClassLoader();

        //Получаем все интерфейсы, которые реализует оригинальный объект
        Class[] interfaces = vasia.getClass().getInterfaces();

        //Создаем прокси нашего объекта vasia
        Person proxyVasia = (Person) Proxy.newProxyInstance(vasiaClassLoader, interfaces, new PersonInvocationHandler(vasia));

        //Вызываем у прокси объекта один из методов нашего оригинального объекта
        proxyVasia.introduce(vasia.getName());
        proxyVasia.sayAge(vasia.getAge());
        proxyVasia.sayFrom(vasia.getCity(), vasia.getCountry());

    }


}
