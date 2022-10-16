package com.ycj.good.mapper;

import com.ycj.good.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    int getGoodsTotal();
    List<Goods> queryGoodsList(int page, int limit);
    Goods queryGoodsById(String id);
}
