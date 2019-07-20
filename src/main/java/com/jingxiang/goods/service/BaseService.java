package com.jingxiang.goods.service;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();

    List<T> findById(Long id);

    void delete(Long... ids);

    void update(T t);

    void create(T t);
}
