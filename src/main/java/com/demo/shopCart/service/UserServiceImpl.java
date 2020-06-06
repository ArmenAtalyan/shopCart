package com.demo.shopCart.service;

import com.demo.shopCart.dao.UserDao;
import com.demo.shopCart.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    @Override
    public void addUser(User user) {
       userDao.save(user);
    }

    @Override
    public User findById(int id) {
        Optional<User> result = userDao.findById(id);
        User user;
        if(result.isPresent())
            user = result.get();
        else
            throw new RuntimeException("There was no user with id: " + id);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteById(id);
    }
}
