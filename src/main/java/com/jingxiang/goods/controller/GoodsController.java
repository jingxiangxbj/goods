package com.jingxiang.goods.controller;

import com.jingxiang.goods.entity.Goods;
import com.jingxiang.goods.entity.PageResult;
import com.jingxiang.goods.entity.Result;
import com.jingxiang.goods.service.GoodsService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    public String index(){
        return "index";
    }
    @RequestMapping("/findByConPage")
    public PageResult<Goods> getPageGoods(Goods goods,@RequestParam("pageCode") int pageCode,@RequestParam("pageSize") int pageSize){
        return goodsService.findByPage(goods,pageCode,pageSize);
    }
    @RequestMapping("/create")
    public Result create(@RequestBody Goods goods){
        try {
            goodsService.create(goods);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"添加失败！");
        }
        return new Result(true,"添加成功！");
    }
    @RequestMapping("/update")
    public Result update(@RequestBody Goods goods){
        try {
            goodsService.update(goods);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"修改失败！");
        }
        return new Result(true,"修改成功！");

    }
    @RequestMapping("/delete")
    public Result delete(@RequestBody Long ... ids){
        try {
            goodsService.delete(ids);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"删除失败！");
        }
        return new Result(true,"删除成功！");
    }
    @RequestMapping("findById")
    public List<Goods> findById(@RequestParam("id") Long id){
       return goodsService.findById(id);
    }
}
