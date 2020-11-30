package com.wxb.mp.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.ToString;

/**
 * product
 * @author 
 */
@Data
@ToString
public class Product implements Serializable {
    /**
     * 账户id
     */
    private Integer id;

    /**
     * 账户余额
     */
    private Integer count;

    /**
     * 描述
     */
    private String description;

    /**
     * 用户id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> list1 = list.stream().filter((i) -> i % 2 != 0).collect(Collectors.toList());
        System.out.println(list1);
    }
}