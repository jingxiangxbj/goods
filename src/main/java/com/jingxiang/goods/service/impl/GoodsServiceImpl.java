package com.jingxiang.goods.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jingxiang.goods.entity.Goods;
import com.jingxiang.goods.entity.PageResult;
import com.jingxiang.goods.mapper.GoodsMapper;
import com.jingxiang.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public PageResult findByPage(Goods goods, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        Page<Goods> goodsPage = goodsMapper.findByPage(goods);
        return new PageResult(goodsPage.getTotal(), goodsPage.getResult());
    }

    @Override
    public List<Goods> findAll() {
        return goodsMapper.findAll();
    }

    @Override
    public List<Goods> findById(Long id) {
        return goodsMapper.findById(id);
    }

    @Override
    public void delete(Long... ids) {
        for (Long id : ids
                ) {
            goodsMapper.delete(id);
        }
    }

    @Override
    public void update(Goods goods) {
        goodsMapper.update(goods);
    }

    @Override
    public void create(Goods goods) {
        goodsMapper.create(goods);
    }
}
