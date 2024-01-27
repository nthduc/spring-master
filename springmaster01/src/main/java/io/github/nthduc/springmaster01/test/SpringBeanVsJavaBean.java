package io.github.nthduc.springmaster01.test;

import java.io.Serializable;

/**
 * Java Bean: Classes adhering to 3 constraints
 * Allow access to their properties using getter and setter methods
 * Implement java.io.Serializable
 *
 * POJO: Plain Old Java Object
 * No Constraint
 * Any Java Object is a POJO
 *
 * Spring Bean: Any Java object that is managed by Spring
 * **/

class Pojo {
    private String text;
    private int number;
    public String toString(){
        return text + ":" + number;
    }
}

class JavaBean implements Serializable { //EJB
    // public no-arg constructor
    public JavaBean(){

    }

    private String text;
    private int number;

    // getter setter

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

public class SpringBeanVsJavaBean {
    public static void main(String[] args){
        Pojo pojo = new Pojo();

        System.out.println(pojo);
    }
}
