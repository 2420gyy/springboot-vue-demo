package com.chen.managesystem.controller;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.managesystem.common.Result;
import com.chen.managesystem.entity.User;
import com.chen.managesystem.service.IUserService;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

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
    private IUserService userService;

    @PostMapping("/saveUser")
    public Result<?> savaUser(@RequestBody User user){
        user.setId(UUID.randomUUID().toString());
        if(StringUtils.isEmpty(user.getPassword())){
            user.setPassword("123456");
        }
        // 创建人
        userService.save(user);
        return Result.success();
    }

    @PostMapping("/login")
    public Result<?> login(@RequestBody User user){
        // 使用昵称登录判断
        User one = userService.getOne(Wrappers.<User>lambdaQuery()
                .eq(User::getNickName, user.getName()).eq(User::getPassword, user.getPassword()));
        if (!ObjectUtils.isEmpty(one)){
            return Result.success(one);
        }else {
            return Result.error("-1","用户名或密码错误");
        }
    }
    @GetMapping("/judgeName")
    public Result<?> judgeName(@RequestParam String nickName){
        User one = userService.getOne(Wrappers.<User>lambdaQuery()
                .eq(User::getNickName, nickName));
        if (ObjectUtils.isEmpty(one)){
            return Result.success();
        }else {
            return Result.error("-1","昵称已经存在");
        }
    }
    @PostMapping("/register")
    public Result<?> register(@RequestBody User user){
        // 用户信息，可以后期填写，这个地方也可以加上（不建议） 默认密码功能（前端校验过）
        // vue传参不熟悉。。。。
        user.setNickName(user.getName());
        user.setName(null);
        if (userService.save(user)){
            return Result.success();
        }else {
            return Result.error("-1","注册失败");
        }
    }

    @PutMapping("/updateUser")
    public Result<?> updateUser(@RequestBody User user){
        LambdaUpdateWrapper<User> wq = new LambdaUpdateWrapper<>();
        wq.eq(User::getId,user.getId());
        userService.update(user,wq);
        return Result.success();
    }
    @DeleteMapping("/deleteUser/{id}")
    public Result<?> deleteUser(@PathVariable("id")String id){
        // ypt 更新时间的工具类
        userService.removeById(id);
        return Result.success();
    }

    @GetMapping("/findUser")
    public Result<?> findUser(@RequestParam(required = false,defaultValue = "1") Integer pageNum
            ,@RequestParam(required = false,defaultValue = "10") Integer pageSize
            ,@RequestParam(defaultValue = "") String search){
        ArrayList<Object> list = new ArrayList<>();
        HashMap<Object, Object> hashMap = new HashMap<>();
        Page<User> userPage =  userService.findUser(pageNum,pageSize,search);
        return Result.success(userPage);
    }

}

