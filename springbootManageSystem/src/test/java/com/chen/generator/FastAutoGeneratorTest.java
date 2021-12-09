package com.chen.generator;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import org.junit.jupiter.api.Test;


//https://github.com/baomidou/generator
//一堆东西。。。
public class FastAutoGeneratorTest {

    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://localhost:3306/springboot_vue_manage?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8", "root", "root");

    @Test
    public void testFastAutoGenerator() {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig(builder -> {
                    builder.author("chenchen")
                            .fileOverride()
                            .outputDir(System.getProperty("user.dir") + "/src/main/java")
                            .enableSwagger();
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.moduleName("user")
                            .parent("com.chen.managesystem");
                })
                // 策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("user");
                })
                .execute();
    }
}
