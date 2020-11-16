package ink.openmind.springbootsamplejspproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
public class SpringbootSampleJspProjectApplication {

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringbootSampleJspProjectApplication.class, args);
    }

}
