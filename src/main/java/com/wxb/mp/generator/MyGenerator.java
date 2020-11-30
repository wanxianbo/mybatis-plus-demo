package com.wxb.mp.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MyGenerator {
    public static void main(String[] args) {
        //创建generator对象
        AutoGenerator generator = new AutoGenerator();
        //使用默认生成器

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        globalConfig.setOpen(false);
        globalConfig.setAuthor("PrideWan");
        globalConfig.setServiceImplName("%sService");
        generator.setGlobalConfig(globalConfig);

        //配置datasourceConfig
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/mp_test?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        generator.setDataSource(dataSourceConfig);

        //包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.wxb.mp");
        packageConfig.setModuleName("generator");//模块名
        //使用默认值即可，以下为默认值
//        packageConfig.setController("controller");
//        packageConfig.setService("service");
//        packageConfig.setServiceImpl("service.impl");
//        packageConfig.setMapper("mapper");
//        packageConfig.setEntity("entity");
        generator.setPackageInfo(packageConfig);
        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        //生成部分表
        strategyConfig.setInclude("user");
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        //表名映射为驼峰
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //表字段映射为驼峰
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        generator.setStrategy(strategyConfig);

        //执行
        generator.execute();
    }
}
