package ink.openmind.springbootsampleshirodemoproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: 其他不需要角色就能访问的接口在WebMvc中配置
 * @Author: Wangzz
 * @Version: 1.0.0
 * @CreateDate: Created in 2021/9/28 21:10
 * @UpdateDate: [dateFormat:YYYY-MM-DD][modifier][description]
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/unauthorized").setViewName("unauthorized");
    }
}
