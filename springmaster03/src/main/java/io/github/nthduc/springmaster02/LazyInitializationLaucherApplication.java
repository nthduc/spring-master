package io.github.nthduc.springmaster02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Default initialization for Spring Beans : EAGER
 * */

@Component
class ClassA {

}

@Component
@Lazy
class classB {

    private ClassA classA;
    public classB(ClassA classA){
        // Logic
        System.out.println("Some initialization logic");
        this.classA = classA;
    }

    public void doSomething(){
        System.out.println("Do Something");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLaucherApplication {
    public static void main(String[] args){
        try(var context = new AnnotationConfigApplicationContext(LazyInitializationLaucherApplication.class)){

            System.out.println("Initialization of context is complete");

            context.getBean(classB.class).doSomething();
            //Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
