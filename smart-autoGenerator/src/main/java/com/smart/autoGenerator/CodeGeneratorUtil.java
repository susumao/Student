package com.smart.autoGenerator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGeneratorUtil {
//    @Autowired
//    private ApplicationContext applicationContext;
public static void main(String[] args) {

}

    public void autoGenerator() {
//        String property = applicationContext.getEnvironment().getProperty("");

        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = "D:\\projectDemo\\demo\\smart-autoGenerator";//项目的当前位置的路径
        globalConfig.setOutputDir(projectPath + "/src/main/java");//生成的代码放到哪个路径
        globalConfig.setAuthor("");
        globalConfig.setOpen(false); //生成后是否打开资源管理器
        globalConfig.setFileOverride(false); //重新生成时文件是否覆盖
        globalConfig.setServiceName("%sService"); //去掉Service接口的首字母I
        globalConfig.setIdType(IdType.ASSIGN_ID); //主键策略
        globalConfig.setDateType(DateType.ONLY_DATE); //定义生成的实体类中日期类型
        globalConfig.setSwagger2(false); //开启Swagger2模式
        mpg.setGlobalConfig(globalConfig);

        //配置数据库信息
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://8.135.80.166:3306/demo?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        mpg.setDataSource(dataSourceConfig);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null); //模块名
        pc.setParent("com.smart");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();
//        strategy.setInclude("student");//对哪一张表生成代码
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setTablePrefix(pc.getModuleName() + "_"); //生成实体时去掉表前缀
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作
        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符
        mpg.setStrategy(strategy);

        //6.执行
        mpg.execute();
    }
}
