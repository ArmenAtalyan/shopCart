package com.demo.shopCart.service;

import com.demo.shopCart.model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    void addUser(User user);

    User findById(int id);

    void deleteUser(int idd);
}
