package io.github.nthduc.springmaster02;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
class SomeClass{
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency){
        super();
        this.someDependency = someDependency;
        System.out.println("All Dependency are ready !");
    }

    @PostConstruct
    public void initialize(){
        someDependency.getReady();
    }

}

@Component
class SomeDependency {

    public void getReady() {
    System.out.println("Some logic using SomeDependency");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Clean up");

    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationContextLauncherApplication {
    public static void main(String[] args){
        try(var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncherApplication.class)){

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
