package com.zh.service.impl;

import com.zh.pojo.User;
import com.zh.mapper.UserMapper;
import com.zh.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Beloved
 * @since 2020-05-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
