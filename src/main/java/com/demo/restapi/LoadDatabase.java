package com.demo.restapi;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import  org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository repository){ //All Command Line Runner Beans will be executed once application is loaded
        return args -> { //As there is no database quite yet I will write existing values here for testing
            log.info("Preloading values" + repository.save(new User("Georg","Maier","georg.maier@web.de")));
            log.info("Preloading values" + repository.save(new User("Lukas","Fischer","lukas.fischer@web.de")));
        };
    }
}
