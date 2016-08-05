package spc;
/**
 * Created by YogeshK on 2015-08-20.
 */


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import spc.access.role.UserRoles;
import spc.access.role.UserRolesReposiotry;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

@ComponentScan
@EnableAutoConfiguration
@PropertySource("classpath:/application.properties")
@SpringBootApplication
public class Application implements EmbeddedServletContainerCustomizer {


    //@Autowired
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    @Value("${classpath:webapp/jsp  }")

    private String documentRoot;
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(Application.class);
//    }


    public static void main(String[] args) {

        System.out.println("2 Let's inspect the beans provided by Spring Boot:");

        log.debug("enterred in the main");
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        //ApplicationContext ctx = SpringApplication.run(Application.class, args);
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
       // appConfig=new AppConfig();
        int x= 0;
        //log.debug(enviornment.getProperty("spring.datasource.username"));
//        Properties configFile = new Properties();
//        configFile.load(this.getClass().getClassLoader().getResourceAsStream("/application.properties"));

    }

    @Bean
    public CommandLineRunner demo(UserRolesReposiotry repository) {
        return (args) -> {
            // fetch all customers
            log.info("Customers found with findAll():");

            log.info("-------------------------------");
            if(repository.count()> 0){
                for (UserRoles customer : repository.findAll()) {
                    System.out.println(customer.toString());
                }
                System.out.println(repository.findByUserType("partner"));
            }else{
                // save a couple of customers
                repository.save(new UserRoles("Admin"));
                repository.save(new UserRoles("partner"));
                repository.save(new UserRoles("supdmin"));
                repository.save(new UserRoles("intuser"));
                repository.save(new UserRoles("user"));

            }


            // fetch an individual customer by ID
            UserRoles customer = repository.findOne(1);
            log.info("Customer found with findOne(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");





        };
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {

    }
}