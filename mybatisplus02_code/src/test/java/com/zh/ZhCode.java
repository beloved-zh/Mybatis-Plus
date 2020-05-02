package com.zh;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

import static com.baomidou.mybatisplus.annotation.FieldFill.INSERT;
import static com.baomidou.mybatisplus.annotation.FieldFill.INSERT_UPDATE;

/**
 * 代码自动生成
 */
public class ZhCode {

    public static void main(String[] args) {
        //需要构建一个代码自动生成器对象
        AutoGenerator mpg = new AutoGenerator();

        //配置策略

        //1、全局配置
        GlobalConfig gc = new GlobalConfig();
        //获取当前系统目录
        String projectPath = System.getProperty("user.dir");
        //输出位置
        gc.setOutputDir(projectPath+"/src/main/java");
        //作者
        gc.setAuthor("Beloved");
        //是否打开资源管理器
        gc.setOpen(false);
        //是否覆盖原来生成的
        gc.setFileOverride(false);
        //自动生成service前面又I前缀  ，通过正则表达式去除
        gc.setServiceName("%sService");
        //设置主键生成策略
        gc.setIdType(IdType.AUTO);
        //设置时间格式
        gc.setDateType(DateType.ONLY_DATE);
        //是否设置Swagger
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        //2、设置数据源
        DataSourceConfig config = new DataSourceConfig();
        config.setUrl("jdbc:mysql://localhost:3306/mybatis_plus");
        config.setDriverName("com.mysql.cj.jdbc.Driver");
        config.setUsername("root");
        config.setPassword("123456");
        config.setDbType(DbType.MYSQL);
        mpg.setDataSource(config);

        //3、包的配置
        PackageConfig pc = new PackageConfig();
        //模块名
        pc.setModuleName("");
        //生成在那个包下
        pc.setParent("com.zh");
        //实体类包名
        pc.setEntity("pojo");
        //dao层包名
        pc.setMapper("mapper");
        //service包名
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        //controller包名
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        //4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        //需要生成的表，可以传入多个参数
        strategy.setInclude("user");
        //表表和列的命名规则    下划线转驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //自动lombok
        strategy.setEntityLombokModel(true);
        //逻辑删除
        strategy.setLogicDeleteFieldName("deleted");
        //自动填充策略
        TableFill createTime = new TableFill("create_time", INSERT);
        TableFill updateTime = new TableFill("update_time", INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        strategy.setTableFillList(tableFills);
        //乐观锁
        strategy.setVersionFieldName("version");
        //开启controller驼峰命名格式
        strategy.setRestControllerStyle(true);
        //设置链接请求为下划线  localhost:8080//hello_v1_v2
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);

        //执行
        mpg.execute();
    }

}














































