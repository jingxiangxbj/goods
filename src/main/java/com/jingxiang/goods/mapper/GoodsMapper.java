package com.jingxiang.goods.mapper;

import com.github.pagehelper.Page;
import com.jingxiang.goods.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @auther TyCoding
 * @date 2018/9/19
 */
@Mapper
public interface GoodsMapper {

    List<Goods> findAll();

    Page<Goods> findByPage(Goods goods);

    List<Goods> findById(Long id);

    void create(Goods goods);

    void update(Goods goods);

    void delete(Long id);
}
