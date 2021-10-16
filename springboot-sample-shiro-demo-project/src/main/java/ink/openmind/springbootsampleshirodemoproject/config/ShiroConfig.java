package ink.openmind.springbootsampleshirodemoproject.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: Shiro框架配置类
 * @Author: Wangzz
 * @Version: 1.0.0
 * @CreateDate: Created in 2021/9/28 20:50
 * @UpdateDate: [dateFormat:YYYY-MM-DD][modifier][description]
 */
@Configuration
public class ShiroConfig {
    /**
     * 直接配置了两个用户
     * - sang / 123
     * - admin / 123
     *
     * 对应角色： user 和 admin
     * user具有read权限
     * admin具有read、write权限
     * */
    @Bean
    public Realm realm(){
        TextConfigurationRealm realm = new TextConfigurationRealm();
        realm.setUserDefinitions("sang=123,user\n admin=123,admin");
        realm.setRoleDefinitions("admin=read,write\n user=read");
        return realm;
    }

    /**
     * 配置基本过滤器
     * /login、/doLogin可以匿名访问
     * /logout 是一个注销登录请求
     * ★ 其余请求必须经过认证后才能访问
     * */
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition defaultShiroFilterChainDefinition =
                new DefaultShiroFilterChainDefinition();
        defaultShiroFilterChainDefinition.addPathDefinition("/login", "anon");
        defaultShiroFilterChainDefinition.addPathDefinition("/doLogin", "anon");
        defaultShiroFilterChainDefinition.addPathDefinition("/logout", "anon");
        defaultShiroFilterChainDefinition.addPathDefinition("/**", "anon");
        return defaultShiroFilterChainDefinition;
    }

    /**
     * 为了支持Thymeleaf中使用Shiro标签
     * */
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

}
