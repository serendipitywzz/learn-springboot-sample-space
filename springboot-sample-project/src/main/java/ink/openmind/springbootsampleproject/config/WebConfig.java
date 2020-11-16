package ink.openmind.springbootsampleproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/11 8:36
 * DESC
 */
// 设置配置类
@Configuration
public class WebConfig implements WebMvcConfigurer {
//    // 重写addResourceHandlers方法
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        // 设置静态资源路径为 /**, 资源位置为类路径下的upload
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/upload/");
//    }
}
