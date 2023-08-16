package com.itgf;



import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author 18834
 * @version 1.0
 * @作者 无唔之物
 * @GitHub https://github.com/Flybirdsandcicada
 * @description 代码生成类
 * @date 2023/8/15 14:09
 */
public class CodeGenerator {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/vhr?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "itgf";
        String product="adjustsalary,appraise,department,employee,employeeec,employeeremove,employeetrain,empsalary,flyway_schema_history,hr,hr_role,joblevel,mail_send_log,menu,menu_role,msgcontent,nation,oplog,politicsstatus,position,role,salary,sysmsg";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("无唔之物") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E:\\java_project\\hr_manage\\hr_manage\\hrserver\\hr_module\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.itgf") // 设置父包名
                            .moduleName("sys") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "E:\\java_project\\hr_manage\\hr_manage\\hrserver\\hr_module\\src\\main\\java\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(product) // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}