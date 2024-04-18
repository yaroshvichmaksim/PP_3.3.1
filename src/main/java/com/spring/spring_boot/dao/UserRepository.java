package com.spring.spring_boot.dao;

import com.spring.spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//    void addUser(User user);
//
//    void editUser(User user);
//
//    void deleteUser(int id);
//
//    User getUser(int id);
//
//    List<User> getAllUsers();

}
