package com.wxb.mp.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxb.mp.mapper.UserMapper;
import com.wxb.mp.pojo.ProductVO;
import com.wxb.mp.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void test02() {
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }


    @Test
    public void test03() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //like
        queryWrapper.like("name", "o");
        //notLike
        //likeLeft
        //likeRight
        List<User> users = userMapper.selectList(queryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test04() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        Map<String, Object> map = new HashMap<>();
//        map.put("id", 1L);
//        map.put("name","Jone");
        // 多个条件等于 =
        //queryWrapper.allEq(map,false);
        //filter过滤条件函数
        //queryWrapper.allEq((k,v) -> k.contains("a"),map,false);
        //不等于 <>
        //queryWrapper.ne("name","Jone");
        // 大于 > gt
        queryWrapper.gt("age", 20);
        // 大于等于 >= ge
        //queryWrapper.ge("age", 20);
        // 小于 < lt
        //queryWrapper.lt("age", 20);
        // 小于等于 <= le
        //queryWrapper.le("age", 20);
        //between
        //queryWrapper.between("age", 18, 20);
        //notBetween
        //queryWrapper.notBetween("age", 18, 20);
        //isNull
        //queryWrapper.isNull("name");
        //isNotNull
        //queryWrapper.isNotNull("name");
        //in
        //queryWrapper.in("age", 18, 20, 22);
        //notIn
        //queryWrapper.notIn("age", 18,20,22 );
        //inSql
        //queryWrapper.inSql("id","select id from `user` where id < 3");
        //notInSql
        //queryWrapper.notInSql("id", "select id from `user` where id < 3");
        // 分组 groupBy
        //queryWrapper.groupBy("id","name");
        //orderByAsc 升序
        //queryWrapper.orderByAsc("name");
        //orderByDesc 降序
        //queryWrapper.orderByDesc("id");
        //func 方法(主要方便在出现if...else下调用不同方法能不断链)
//        queryWrapper.func(i ->{
//            if (true) {
//                i.eq("id", 1L);
//            } else {
//                i.ne("id", 1L);
//            }
//        });
        //or
        //queryWrapper.or(i -> i.eq("name", "Jack").ne("age", 20));
        //and
        //queryWrapper.and(i -> i.eq("name", "Jack").ne("age", 20));
        //设置查询字段
        //queryWrapper.select("age,name");
        //List<User> users = userMapper.selectList(queryWrapper);
        //List<User> users = userMapper.selectList(null);
        //根据多个id主键查询
        //List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        //查询记录的条数
        //System.out.println(userMapper.selectCount(queryWrapper));
        // 根据map等值条件查询
//        Map<String, Object> map = new HashMap<>();
//        map.put("id", 1L);
//        map.put("name","Jone");
//        List<User> users = userMapper.selectByMap(map);
        //查询单个对象，多个无法查询
//        queryWrapper.eq("id", 1);
//        System.out.println(userMapper.selectObjs(queryWrapper));
        //查询结果封装为Map集合的List
//        userMapper.selectMaps(queryWrapper).forEach(System.out::println);
        //users.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("潘");
        user.setAge(24);
        user.setEmail("pan@163.com");
        int count = userMapper.insert(user);
        System.out.println(count);
    }

    @Test
    public void testUpdate() {
        User user = userMapper.selectById(7);
        user.setName("王三");
        int count = userMapper.updateById(user);
        System.out.println(count);
        System.out.println(user);
    }

    @Test
    public void testDel() {
        int count = userMapper.deleteById(7);
        System.out.println(count);
    }

    @Test
    public void testPage() {
        Page<User> page = new Page<>(1, 2);
        Page<User> userPage = userMapper.selectPage(page, null);
        System.out.println("total:" + userPage.getTotal());
        System.out.println("当前页数 ------> " + userPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userPage.getSize());
        userPage.getRecords().forEach(System.out::println);
    }

    @Test
    public void testPage2() {
        PageHelper.startPage(0, 2);
        List<User> userList = userMapper.selectList(null);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println(pageInfo.getPageNum());
        System.out.println(pageInfo.getPages());
        System.out.println(pageInfo.getPageSize());
    }

    @Test
    public void testProduct() {
        List<ProductVO> productList = userMapper.findProductList(7L);
        productList.forEach(System.out::println);
    }
}