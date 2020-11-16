package ink.openmind.springbootsampleredislearnproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@RestController
public class SpringbootSampleRedisLearnProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSampleRedisLearnProjectApplication.class, args);
    }

    @RequestMapping("/test")
    @ResponseBody
    public String getInfo(){
        return "test";
    }

}
