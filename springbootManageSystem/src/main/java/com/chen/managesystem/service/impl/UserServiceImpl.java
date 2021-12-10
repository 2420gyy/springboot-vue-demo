package com.chen.managesystem.service.impl;

import com.chen.managesystem.entity.User;
import com.chen.managesystem.mapper.UserMapper;
import com.chen.managesystem.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
