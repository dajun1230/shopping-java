package com.ycj.good.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods extends Base {
    String id;
    String goodName;
    int price;
    String description;
    String image;
    int number;
}
