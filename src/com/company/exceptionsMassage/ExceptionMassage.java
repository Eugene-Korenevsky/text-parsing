package com.company.exceptionsMassage;

public class ExceptionMassage implements ExceptionMassages {
    public void exceptionMassage(String name, String massage) {
        System.out.println("Exception in " + name + '\n' + " " + massage);
    }
}
