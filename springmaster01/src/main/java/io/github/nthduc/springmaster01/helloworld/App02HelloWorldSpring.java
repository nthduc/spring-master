package io.github.nthduc.springmaster01.helloworld;

import io.github.nthduc.springmaster01.data.Address;
import io.github.nthduc.springmaster01.data.Person;
import io.github.nthduc.springmaster01.config.HelloWorldConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args){
        // 1. Lauch a Spring Context

        try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){
            // 2. Configure the things that we want Springs to manage
            // HelloWorldConfiguration -> @Configguration
            // name -> @Bean

            System.out.println(context.getBean("name")); // --> get Bean có tên là name
            System.out.println(context.getBean("age")); // --> get Bean có tên là age
            System.out.println(context.getBean("person")); // --> get Bean có tên là person
            System.out.println(context.getBean(Address.class)); // --> get Bean có tên là address
            System.out.println(context.getBean("Person2MethodCall")); // --> get Bean có tên là person
            System.out.println(context.getBean("person3Parameters")); // --> get Bean có tên là person

            System.out.println(context.getBean(Person.class)); // --> get Bean có tên là person

            System.out.println(context.getBean("person5Qualifier")); // --> get Bean có tên là person5Qualifier



//        Arrays.stream(context.getBeanDefinitionNames())
//                .forEach(System.out::println);

        }







    }
}
