package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.entity.User;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisPlusApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getAll(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void addUser(){

        User user = new User();
        user.setName("zhaoliu");
        user.setAge(42);
        user.setEmail("wzhao6@afdas.com");

        userMapper.insert(user);
    }

    @Test
    public void updateUser(){
        User user = userMapper.selectById(1546563374175514625L);
        //user.setId(1546563374175514625L);
        user.setName("wangwuUP");
        userMapper.updateById(user);
    }

    @Test
    public void selectByIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1,2,3));
        users.forEach(System.out::println);
    }

    @Test
    public void selectByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","li4");
        map.put("age",42);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    public void selectByPage(){
        Page<User> page = new Page<>(1,3);
        //IPage<User> userIPage = userMapper.selectPage(userPage, null);
        userMapper.selectPage(page,null);
        List<User> records = page.getRecords();
        records.forEach(System.out::println);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    @Test
    public void selectByInfo(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","li4");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

}
