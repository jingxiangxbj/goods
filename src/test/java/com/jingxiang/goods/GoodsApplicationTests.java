package com.jingxiang.goods;

import com.jingxiang.goods.entity.Goods;
import com.jingxiang.goods.mapper.GoodsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsApplicationTests {
    @Autowired
private GoodsMapper goodsMapper;
    @Test
    public void contextLoads() {
        List<Goods> all = goodsMapper.findAll();
        System.out.println(all);
    }

}
