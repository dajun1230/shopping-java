package com.ycj.good.service.impl;

import com.ycj.good.mapper.GoodsMapper;
import com.ycj.good.pojo.Goods;
import com.ycj.good.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public int getGoodsTotal(){
        return goodsMapper.getGoodsTotal();
    }

    @Override
    public Goods queryGoodsById(String id){
        return goodsMapper.queryGoodsById(id);
    }

    @Override
    public List<Goods> queryGoodsList(int page, int limit){
        int start = (page - 1) * limit;
        return goodsMapper.queryGoodsList(start, limit);
    }
}
