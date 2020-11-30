package com.wxb.mp.enums;


import com.baomidou.mybatisplus.annotation.EnumValue;

public enum EnumStatus {
    WORK(1, "工作"),
    REST(2, "休息")
    ;
    @EnumValue
    private Integer status;
    private String msg;

    EnumStatus(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
