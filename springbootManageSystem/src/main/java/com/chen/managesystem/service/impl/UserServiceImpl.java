package com.chen.managesystem.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.managesystem.entity.User;
import com.chen.managesystem.mapper.UserMapper;
import com.chen.managesystem.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenchen
 * @since 2021-12-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public Page<User> findUser(Integer pageNum, Integer pageSize, String search) {
        Page<User> userPage = baseMapper.selectPage(new Page<>(pageNum, pageSize), Wrappers.<User>lambdaQuery()
                .like(User::getName, search)
                .or()
                .like(User::getNickName, search));
        return userPage;
    }

}
