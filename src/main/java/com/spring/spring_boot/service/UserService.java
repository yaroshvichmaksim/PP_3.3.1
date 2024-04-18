package com.spring.spring_boot.service;


import com.spring.spring_boot.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

//    void updateUser(User user);

    void deleteUser(int id);

    User getUser(int id);

    List<User> getAllUsers();
}
