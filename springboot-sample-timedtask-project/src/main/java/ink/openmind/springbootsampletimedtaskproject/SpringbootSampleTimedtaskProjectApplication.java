package ink.openmind.springbootsampletimedtaskproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@RestController
@EnableScheduling // 使定时任务生效
public class SpringbootSampleTimedtaskProjectApplication {

    @GetMapping("/hello")
    @ResponseBody
    public String printInfo(){
        return "We are the world!";
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringbootSampleTimedtaskProjectApplication.class, args);
    }

}
