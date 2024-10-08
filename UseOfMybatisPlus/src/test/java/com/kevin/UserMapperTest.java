package com.kevin;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.kevin.mapper.UserMapper;
import com.kevin.po.Address;
import com.kevin.po.User;
import com.kevin.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    void testInsert() {
        User user = new User();
        user.setId(5L);
        user.setUsername("Lucy");
        user.setPassword("123");
        user.setPhone("18688990011");
        user.setBalance(200);
        user.setInfo("{\"age\": 24, \"intro\": \"英文老师\", \"gender\": \"female\"}");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
    }

    @Test
    void testSelectById() {
        User user = userMapper.selectById(5L);
        System.out.println("user = " + user);
    }


//    @Test
//    void testQueryByIds() {
//
//        List<User> users = userMapper.selectBatchIds();
//        users.forEach(System.out::println);
//    }

    @Test
    void testUpdateById() {
        User user = new User();
        user.setId(5L);
        user.setBalance(20000);
        userMapper.updateById(user);
    }

    @Test
    void testDeleteUser() {
        userMapper.deleteById(5L);
    }

    @Test
    void testQueryWrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "jack");
        userMapper.selectCount(wrapper);
    }

    @Test
    void testLambdaQueryWapper(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .select(User::getId)
                .like(User::getUsername, "o")
                .ge(User::getBalance, 1000);
        List<User> userList = new ArrayList<>();
    }
    @Test
    void testDb(){
        List<Address> list = Db.lambdaQuery(Address.class)
                .eq(Address::getUserId, 2)
                .list();
    }

    @Test
    void testPage(){
        Page<User> page = Page.of(1, 5);
        Page<User> p = userService.page(page);
        List<User> list = p.getRecords();
    }

}