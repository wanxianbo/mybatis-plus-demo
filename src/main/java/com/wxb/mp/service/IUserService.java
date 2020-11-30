package com.wxb.mp.service;

import com.wxb.mp.pojo.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserService {
    Mono<User> findOneById(Long id);

    Flux<User> findAll();

    Mono<Void> save(Mono<User> userMono);
}
