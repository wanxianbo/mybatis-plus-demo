package com.wxb.mp.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("product")
@Data
public class ProductVO {
    private Integer id;
    private Integer count;
    private String description;
    private Long userId;
    private String username;
}
