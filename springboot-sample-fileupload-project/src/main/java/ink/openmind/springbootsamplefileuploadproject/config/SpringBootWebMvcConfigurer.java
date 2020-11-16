package ink.openmind.springbootsamplefileuploadproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/14 20:21
 * DESC
 */
@Configuration
public class SpringBootWebMvcConfigurer implements WebMvcConfigurer {
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        /*
        *  通过该配置，所有以/files/开头的静态资源请求都会映射到/home/project/upload目录下，与前面上传文件时设置目录类似
        * 不同的系统eg: Linux和Windows，文件路径的写法不相同
        * */
        registry.addResourceHandler("/files/**")
                .addResourceLocations("file:e:\\SoftDevWorkspace\\JavaEE\\learn-springboot-sample-space\\springboot-sample-fileupload-project\\upload\\");

    }

}
