package com.wxb.mp.service.impl;

import com.wxb.mp.mapper.UserMapper;
import com.wxb.mp.pojo.User;
import com.wxb.mp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Mono<User> findOneById(Long id) {
        User user = userMapper.selectById(id);
        return Mono.justOrEmpty(user);
    }

    @Override
    public Flux<User> findAll() {
        List<User> users = userMapper.selectList(null);
        return Flux.fromIterable(users);
    }

    @Override
    public Mono<Void> save(Mono<User> userMono) {
        return userMono.doOnNext(user -> userMapper.insert(user)).thenEmpty(Mono.empty());
    }
}
