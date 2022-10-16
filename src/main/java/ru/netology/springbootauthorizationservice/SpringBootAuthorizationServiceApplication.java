package ru.netology.springbootauthorizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.netology.springbootauthorizationservice.repository.UserRepository;
import ru.netology.springbootauthorizationservice.service.AuthorizationService;

@SpringBootApplication
public class SpringBootAuthorizationServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootAuthorizationServiceApplication.class, args);

        AuthorizationService authorizationService = context.getBean(AuthorizationService.class);
        UserRepository userRepository = context.getBean(UserRepository.class);
    }
}
