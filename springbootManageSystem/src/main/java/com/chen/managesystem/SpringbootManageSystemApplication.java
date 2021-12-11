package com.chen.managesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// TODO 这个地方在TokenUtils里面无效？？？
@MapperScan("com.chen.managesystem.mapper")
public class SpringbootManageSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootManageSystemApplication.class, args);
        // 启动打开默认浏览器访问
        try {
            Runtime.getRuntime().exec("cmd /c start http://localhost:9090/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
