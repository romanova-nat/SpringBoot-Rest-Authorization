package ru.netology.springbootauthorizationservice.model;

import javax.validation.constraints.Size;
import java.util.Objects;

public class User {
    @Size(max = 10)
    private String name;

    @Size(min = 3)
    private String pass;

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) && pass.equals(user.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pass);
    }
}

