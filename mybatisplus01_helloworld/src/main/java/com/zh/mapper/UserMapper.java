package com.zh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zh.pojo.User;
import org.springframework.stereotype.Repository;

// 使用mybatis——puls 在对应的Mapper上继承基本的接口BaseMapper
@Repository   //代表持久层
public interface UserMapper extends BaseMapper<User> {

    /*
     * 继承BaseMapper，所以的CRUD就已经可以使用
     */

}
