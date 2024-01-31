package io.github.nthduc.springboot.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan("io.github.nthduc.springboot.todoapp.repositories")
public class SpringbootMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMasterApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**")
						.allowedMethods("*")
						.allowedOrigins("http://localhost:3000");
			}
		};
	}

}
