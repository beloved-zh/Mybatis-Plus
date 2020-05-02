package com.zh;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zh.mapper.UserMapper;
import com.zh.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void test01(){
        //查询name和age不为空，且age>=23

        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper
                .isNotNull("name")
                .isNotNull("age")
                .ge("age",23);

        List<User> list = mapper.selectList(wrapper);//和map类似

        list.forEach(System.out::println);
    }

    @Test
    public void test02(){
        //查询name为Beloved

        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.eq("name","Beloved");

        //查询一条数据，多条用list或者map
        User user = mapper.selectOne(wrapper);

        System.out.println(user);
    }

    @Test
    public void test03(){
        //查询age到20~30之间

        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.between("age",20,30);

        List<User> list = mapper.selectList(wrapper);

        list.forEach(System.out::println);

        //统计数
        System.out.println(mapper.selectCount(wrapper));
    }

    @Test
    public void test04(){
        //模糊查询

        QueryWrapper<User> wrapper = new QueryWrapper<>();

        // name中不包含a，且邮箱是t开头
        // likeRight    t%
        // likeLeft     %t
        wrapper.notLike("name","a")
                .likeRight("email","t");

        List<Map<String, Object>> map = mapper.selectMaps(wrapper);

        map.forEach(System.out::println);
    }

    @Test
    public void test05(){
        //子查询

        QueryWrapper<User> wrapper = new QueryWrapper<>();

        // id在子查询中的数据
        // inValue:可以是eq...
        wrapper.inSql("id","select id from user where id < 3");

        List<User> objects = mapper.selectList(wrapper);

        objects.forEach(System.out::println);
    }

    @Test
    public void test06(){
        //排序

        QueryWrapper<User> wrapper = new QueryWrapper<>();

        //通过id排序
        wrapper.orderByDesc("id");

        List<User> list = mapper.selectList(wrapper);

        list.forEach(System.out::println);
    }
}
