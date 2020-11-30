package com.wxb.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxb.mp.pojo.ProductVO;
import com.wxb.mp.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<ProductVO> findProductList(@Param("userId") Long userId);
}
