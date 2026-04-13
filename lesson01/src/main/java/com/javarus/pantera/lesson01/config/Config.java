package com.javarus.pantera.lesson01.config;

import com.javarus.pantera.lesson01.repository.UserRepository;
import com.javarus.pantera.lesson01.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class Config {

    @Bean
    public SessionCreator getSessionCreator(ApplicationProperties applicationProperties) {
        return new SessionCreator(applicationProperties);
    }

    @Bean
    UserRepository getUserRepository(SessionCreator sessionCreator) {
        return new UserRepository(sessionCreator);
    }

     @Bean
    public UserService getUserService(UserRepository userRepository) {
        return new UserService(userRepository);
     }
}
