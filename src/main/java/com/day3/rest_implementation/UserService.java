package com.day3.rest_implementation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope("application")
public class UserService {
    List<User> allUser = new ArrayList<>();

    public void insertUser(User newUser) {
        allUser.add(newUser);
    }

    public User getUser(String id) {
        for (User user : allUser) {
            if (id.equals(user.getId())) {
                return user;
            }
        }
        return null;
    }

}
