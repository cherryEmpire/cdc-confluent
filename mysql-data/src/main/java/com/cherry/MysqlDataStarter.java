package com.cherry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/1/30 16:24
 * @Description: MysqlDataStarter
 */
@EnableOpenApi
@EnableWebMvc
@SpringBootApplication
@ComponentScan(basePackages = "com.cherry.*")
public class MysqlDataStarter {
    public static void main(String[] args) {
        SpringApplication.run(MysqlDataStarter.class, args);
    }
}
