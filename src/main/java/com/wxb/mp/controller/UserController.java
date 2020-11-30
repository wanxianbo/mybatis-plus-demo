package com.wxb.mp.controller;

import com.wxb.mp.pojo.User;
import com.wxb.mp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/user/{id}")
    public Mono<User> getUser(@PathVariable("id") Long id) {
        return userService.findOneById(id);
    }

    @GetMapping("/user")
    public Flux<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping("/user/save")
    public Mono<Void> saveUser(@RequestBody User user) {
        Mono<User> userMono = Mono.just(user);
        return userService.save(userMono);
    }
}
