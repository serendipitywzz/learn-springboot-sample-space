package ink.openmind.springbootsampleshirodemoproject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Apache Shiro 是一个开源的轻量级Java安全框架  主要功能： 【用户认证】【用户授权】【密码管理】以及【会话管理】
 * */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Application {
    private static final transient Logger log = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}