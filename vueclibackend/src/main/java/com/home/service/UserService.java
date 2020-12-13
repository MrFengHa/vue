package com.home.service;

import com.home.entity.User;

import java.util.List;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/12/13 18:52
 */
public interface UserService {
    void save(User user);
    void update(User user);
    void delete(String id);
    List<User> findAll();
    User findById(String id);
}
