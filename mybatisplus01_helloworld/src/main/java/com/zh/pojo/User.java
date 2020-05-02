package com.zh.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //对应数据库的主键
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    //插入时更新
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    //插入修改时更新
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version  //乐观锁version注解
    private Integer version;

    @TableLogic  //逻辑删除
    private int deleted;

}
