package com.kevin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevin.mapper.UserMapper;
import com.kevin.po.User;
import com.kevin.service.UserService;

public class UserServiceImpl
        extends ServiceImpl<UserMapper, User>
        implements UserService {
}
