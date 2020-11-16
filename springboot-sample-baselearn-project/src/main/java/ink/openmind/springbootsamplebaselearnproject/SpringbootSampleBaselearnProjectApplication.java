package ink.openmind.springbootsamplebaselearnproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Controller
public class SpringbootSampleBaselearnProjectApplication {

//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello ! openmind.ink";
//    }

    @GetMapping("/printInfo/{name}")
    @ResponseBody
    public String printInfo(@PathVariable String name){
        return "【info】 " + name; // 【info】 王壮壮
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSampleBaselearnProjectApplication.class, args);
    }

}
