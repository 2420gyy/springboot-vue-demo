package com.chen.managesystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.managesystem.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenchen
 * @since 2021-12-10
 */
public interface IUserService extends IService<User> {

    Page<User> findUser(Integer pageNum, Integer pageSize, String search);
}
