package com.spc; /**
 * Created by YogeshK on 2015-08-20.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;

@ComponentScan
@EnableAutoConfiguration
@PropertySource("classpath:/application.properties")
public class Application {

    public static void main(String[] args) {
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}