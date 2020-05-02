package com.zh;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zh.mapper.UserMapper;
import com.zh.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class Mybatisplus01HelloworldApplicationTests {

    @Autowired
    private UserMapper mapper;

    @Test
    void contextLoads() {
        // 参数是一个Wrapper，条件构造器，使用null
        // 查询全部
        List<User> list = mapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void insert(){
        User user = new User();
        user.setName("Beloved");
        user.setAge(20);
        user.setEmail("1425279634@qq.com");

        int res = mapper.insert(user);  //自动添加id
        System.out.println(res);        //受影响的行数
        System.out.println(user);
    }

    @Test
    public void update(){
        User user = new User();
        user.setId(1256231939020390405L);
        user.setName("Beloved");
        user.setEmail("1425279634@qq.com");

        //虽然名字是updateById  但是参数是一个对象
        int res = mapper.updateById(user);
        System.out.println(res);
    }

    //测试乐观锁成功
    @Test
    public void version01(){

        //查询用户信息
        User user = mapper.selectById(1L);
        //修改用户信息
        user.setName("张三");
        //执行更新操作
        mapper.updateById(user);

    }

    //测试乐观锁失败
    @Test
    public void version02(){
        //线程一
        User user = mapper.selectById(1L);
        user.setName("张三111");

        //线程二
        //模拟另一个线程执行了插队操作
        User user2 = mapper.selectById(1L);
        user2.setName("张三222");
        mapper.updateById(user2);

        //如果没有乐观锁就会覆盖线程插队的值
        mapper.updateById(user);//操作失败
    }

    //根据id查询单个记录
    @Test
    public void selectById(){
        User user = mapper.selectById(1L);
        System.out.println(user);
    }

    //批量查询
    @Test
    public void selectBatchIds(){
        List<User> list = mapper.selectBatchIds(Arrays.asList(1, 2, 3));
        list.forEach(System.out::println);
    }

    //条件查询 map
    @Test
    public void selectByMap(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","Beloved");
        map.put("age",20);
        //动态sql
        List<User> list = mapper.selectByMap(map);
        list.forEach(System.out::println);
    }

    @Test
    //测试分页查询
    public void page(){

        /*
         * current: 当前页
         * size: 每页大小
         */
        Page<User> page = new Page<>(2,3);
        mapper.selectPage(page,null);

        page.getRecords().forEach(System.out::println);

        //总页数
        System.out.println(page.getTotal());
    }


    //根据id删除
    @Test
    public void deleteById(){
        mapper.deleteById(5L);
    }

    //根据id批量删除
    @Test
    public void deleteBatchIds(){
        mapper.deleteBatchIds(Arrays.asList(1,2,3));
    }

    //根据条件
    @Test
    public void deleteByMap(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","Billie");
        mapper.deleteByMap(map);
    }
}
