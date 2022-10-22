package ru.netology.springbootauthorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springbootauthorizationservice.enums.Authorities;
import ru.netology.springbootauthorizationservice.model.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private ConcurrentHashMap<User, List<Authorities>> authorities;

    public UserRepository() {
        authorities = new ConcurrentHashMap<>();
        authorities.put(new User("petya", "1234"), new ArrayList<>(Collections.singleton(Authorities.READ)));
        authorities.put(new User("olya", "2345"), new ArrayList<>(Collections.singleton(Authorities.READ)));
    }

    public List<Authorities> getUserAuthorities(String name, String password) {
        for (User user : authorities.keySet()) {
            if (user.getName().equals(name) && user.getPass().equals(password)) {
                return authorities.get(user);
            }
        }
        return null;
    }
}
