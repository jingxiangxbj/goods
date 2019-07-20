package com.jingxiang.goods.service.impl;

import com.jingxiang.goods.entity.User;
import com.jingxiang.goods.mapper.UserMapper;
import com.jingxiang.goods.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<User> findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public void delete(Long... ids) {
        for (Long id : ids
                ) {
            userMapper.findById(id);
        }
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void create(User user) {
        userMapper.create(user);
    }
}
