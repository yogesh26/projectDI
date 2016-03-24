package spc.utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * Created by YogeshK on 2015-10-28.
 */



@Slf4j
@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    private static boolean started = false;
    private static int targetVersion = 1;
    private static int currVersion = 0;

    @Autowired
    private Environment env;

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        if (!started) {
            dbConnectionRelated();
            started = true;
        }
    }
    public void dbConnectionRelated() throws Exception {
        log.debug("user:{}", env.getProperty("spring.datasource.username"));




    }

}