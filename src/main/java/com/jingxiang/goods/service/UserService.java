package com.jingxiang.goods.service;

import com.jingxiang.goods.entity.User;

import java.util.List;

public interface UserService extends BaseService<User> {
    User findByName(String name);
}
