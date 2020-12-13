package com.home.service.impl;

import com.home.entity.User;
import com.home.mapper.UserMapper;
import com.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/12/13 19:13
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(String id) {
        userMapper.delete(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(String id) {
        return userMapper.findById(id);
    }
}
