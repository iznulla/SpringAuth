package com.auth.simpleauth.service;

import com.auth.simpleauth.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public User findByName(String name) {
        Optional<User> user = users.stream().filter(u -> u.getName().equals(name)).findFirst();
        return user.orElse(null);
    }
}
