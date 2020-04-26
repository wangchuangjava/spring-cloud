package com.wc.mapper;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class TestMP {


    /**
     * 代码生成    示例代码
     */
    @Test
    public void testGenerator() {
        //1. 全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true) // 是否支持AR模式
                .setAuthor("lh") // 作者
                .setOutputDir("E:\\demo2\\src\\main\\java\\com\\zcf\\demo2") // 生成路径
                .setFileOverride(true)  // 文件覆盖D:\\workspace_mp\\mp03\\src\\main\\java
                .setIdType(IdType.AUTO) // 主键策略
                .setServiceName("%sService")  // 设置生成的service接口的名字的首字母是否为I
                // IEmployeeService
                .setBaseResultMap(true)
                .setBaseColumnList(true);

        //2. 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)  // 设置数据库类型
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://101.200.228.203:3306/ennsafety_test?useUnicode=true&useSSL=false&serverTimezone=GMT&nullCatalogMeansCurrent=true&allowMultiQueries=true&characterEncoding=UTF8")
                .setUsername("root")
                .setPassword("jusafe123456");

        //3. 策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) //全局大写命名
//				.setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel).setInclude("hazard_info_count");  // 数据库表映射到实体的命名策略
//				.setTablePrefix("tbl_")
        // 生成的表

        //4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.zcf")
                .setEntity("pojo");

        //5. 整合配置
        AutoGenerator ag = new AutoGenerator();

        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);

        //6. 执行
        ag.execute();
    }


    public static void main(String[] args) {
        //1. 全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true) // 是否支持AR模式
                .setAuthor("王创") // 作者
                .setOutputDir("E:\\demo\\src\\main\\java") // 生成路径
                .setFileOverride(true)  // 文件覆盖D:\\workspace_mp\\mp03\\src\\main\\java
                .setIdType(IdType.UUID) // 主键策略
                .setServiceName("%sService")  // 设置生成的service接口的名字的首字母是否为I
                // IEmployeeService
                .setBaseResultMap(true)
                .setBaseColumnList(true);

        //2. 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)  // 设置数据库类型
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://101.200.228.203:3306/enn_safety?useUnicode=true&useSSL=false&serverTimezone=GMT&nullCatalogMeansCurrent=true&allowMultiQueries=true&characterEncoding=UTF8")
                .setUsername("root")
                .setPassword("Enn123456!");

        //3. 策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) //全局大写命名
//				.setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel).setInclude("sys_project_management","sys_project_management_record","sys_risk_items","sys_risk_items_child","sys_risk_items_child_record");  // 数据库表映射到实体的命名策略
//				.setTablePrefix("tbl_")
        // 生成的表

        //4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.wc")
                .setEntity("entity");

        //5. 整合配置
        AutoGenerator ag = new AutoGenerator();

        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);

        //6. 执行
        ag.execute();
    }
}
