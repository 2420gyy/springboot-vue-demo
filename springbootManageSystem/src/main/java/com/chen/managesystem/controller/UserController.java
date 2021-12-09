package com.chen.managesystem.controller;


import com.chen.managesystem.config.Result;
import com.chen.managesystem.entity.User;
import com.chen.managesystem.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenchen
 * @since 2021-12-10
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserService userService;

    @PostMapping("/savaUser")
    public Result savaUser(@RequestBody User user){
        userService.save(user);
        return Result.success();
    }
}

