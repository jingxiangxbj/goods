package com.jingxiang.goods.service;

import com.jingxiang.goods.entity.Goods;
import com.jingxiang.goods.entity.PageResult;

public interface GoodsService extends BaseService<Goods> {
    PageResult findByPage(Goods goods,int page,int pageSize);
}
