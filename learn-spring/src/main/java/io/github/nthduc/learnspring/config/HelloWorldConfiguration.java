package io.github.nthduc.learnspring.config;

import io.github.nthduc.learnspring.data.Address;
import io.github.nthduc.learnspring.data.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// Eliminate verbosity in creating Java Beans
// Public accessor methods, constructor
// equals, hashcode and toString are automatically created.
// Released in JDK 16

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Nthduc";
    }

    @Bean
    public int age() {
        return 18;
    }

    @Bean
    public Person person() {
        return new Person("Nthduc",18,new Address("Ntduc","HCM"));
    }

    @Bean(name = "address2")
    @Primary
    public Address address() {
        return new Address("Nthduc","London");
    }

    @Bean(name = "address3")
    @Qualifier("address3qualifier")
    public Address address3() {
        return new Address("NthducQualifier","London");
    }

    @Bean
    public Person Person2MethodCall() {
        return new Person(name(),age(),address());
    }

    @Bean
    public Person person3Parameters(String name,int age,Address address2){
        return new Person(name,age,address2);
    }

    @Bean
    @Primary
    public Person person4Parameters(String name,int age,Address address2){
        return new Person(name,age,address2);
    }

    @Bean
    public Person person5Qualifier(String name,int age, @Qualifier("address3qualifier") Address address2){
        return new Person(name,age,address2);
    }
}
