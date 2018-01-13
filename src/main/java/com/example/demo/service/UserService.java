package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;

public interface UserService {
    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);

    User loadUser(int id);

    User findByUserName(String userName);
}
