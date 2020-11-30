package com.wxb.mp.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.wxb.mp.enums.EnumStatus;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@TableName("user")
public class User {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    private Integer version;
    @TableField(value = "status")
    private EnumStatus status;
    @TableLogic
    private Integer deleted;

}
