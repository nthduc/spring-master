package io.github.nthduc.springmaster02;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Default initialization for Spring Beans : EAGER
 * */

@Component
class NormalClass {

}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {

}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {
    public static void main(String[] args){
        try(var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)){

            System.out.println("Initialization of context is complete");

            System.out.println(context.getBean(NormalClass.class)); // same Bean @1b6e1eff
            System.out.println(context.getBean(NormalClass.class)); // same Bean @1b6e1eff

            System.out.println(context.getBean(PrototypeClass.class)); // @306f16f3
            System.out.println(context.getBean(PrototypeClass.class)); // @702b8b12
            System.out.println(context.getBean(PrototypeClass.class)); // @22e357dc

            //Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
