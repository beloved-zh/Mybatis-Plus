package com.zh.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component  //处理器一定要加入ioc容器
public class MyMetaObjectHandler implements MetaObjectHandler {
    //插入的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("开始执行插入的填充策略...");
        //                          字段名             填充的值
        //setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject)
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
    //更新的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("开始执行更新的填充策略...");
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
