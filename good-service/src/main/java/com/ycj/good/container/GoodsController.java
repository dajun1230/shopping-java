package com.ycj.good.container;

import com.ycj.common.utils.ResponseResult;
import com.ycj.good.pojo.Goods;
import com.ycj.good.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/query")
    public ResponseResult getGoodsById(@RequestParam("id") String id) {
        Goods goods = goodsService.queryGoodsById(id);
        return new ResponseResult(200, "", goods);
    }

    @GetMapping("/list")
    public ResponseResult getGoodsList(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        List<Goods> goodsList = goodsService.queryGoodsList(page, limit);
        int total = goodsService.getGoodsTotal();
        HashMap hashMap = new HashMap();
        hashMap.put("total", total);
        hashMap.put("data", goodsList);
        return new ResponseResult(200, "", hashMap);
    }
}
