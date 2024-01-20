package io.github.nthduc.learnspring;

import io.github.nthduc.learnspring.config.HelloWorldConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args){
        // 1. Lauch a Spring Context

        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        // 2. Configure the things that we want Springs to manage

        System.out.println(context.getBean("name")); // --> get Bean có tên là name
    }
}
