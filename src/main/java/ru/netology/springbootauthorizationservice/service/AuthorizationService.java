package ru.netology.springbootauthorizationservice.service;

import org.springframework.stereotype.Service;
import ru.netology.springbootauthorizationservice.enums.Authorities;
import ru.netology.springbootauthorizationservice.exeption.InvalidCredentials;
import ru.netology.springbootauthorizationservice.exeption.UnauthorizedUser;
import ru.netology.springbootauthorizationservice.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;
    List<Authorities> userAuthorities;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}