package ink.openmind.springbootsampleswaggerproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/16 8:51
 * DESC
 */
@Configuration // 启动时加载此类
@EnableSwagger2 // 表示此项目启用Swagger API文档
public class Swagger2Config {

    /**
     * api()方法用于返回实例Docket（Swagger API摘要），也是在该方法中指定需要扫描的控制器包路径，只有
     * 此路径下的Controller类才会自动生成Swagger API文档
     * */
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("ink.openmind.springbootsampleswaggerproject.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * apiIfo()方法中主要配置一些基础信息，包括配置页面展示的基本信息，包括标题、描述、版本、服务、条款、联系方式等
     * */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("swagger-api文档")
                .description("swagger文档 by openmind.ink")
                .version("0.0.1-SNAPSHOT")
                .build();
    }
}
