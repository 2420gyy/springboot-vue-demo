package com.chen.managesystem.mapper;

import com.chen.managesystem.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chenchen
 * @since 2021-12-10
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
