package com.ycj.good;

import com.ycj.good.pojo.Goods;
import com.ycj.good.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GoodsTest {

    @Autowired
    GoodsService goodsService;

    @Test
    void getGoodsList() {
        List<Goods> goodsList = goodsService.queryGoodsList(1, 10);
        System.out.println(goodsList);
    }
}
