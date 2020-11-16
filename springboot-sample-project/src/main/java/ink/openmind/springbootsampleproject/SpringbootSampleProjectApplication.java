package ink.openmind.springbootsampleproject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
* @RestController = @ResponseBody + @Controller
* @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
* @EnableAutoConfiguration ===> 开启Spring自动配置
* */

@SpringBootApplication
public class SpringbootSampleProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSampleProjectApplication.class, args);
    }

}
