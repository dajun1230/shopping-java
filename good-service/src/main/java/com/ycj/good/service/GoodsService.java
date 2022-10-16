package com.ycj.good.service;

import com.ycj.good.pojo.Goods;

import java.util.List;

public interface GoodsService {
    int getGoodsTotal();
    Goods queryGoodsById(String id);
    List<Goods> queryGoodsList(int page, int limit);
}
