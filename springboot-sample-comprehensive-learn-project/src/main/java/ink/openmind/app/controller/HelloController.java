package ink.openmind.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description: 【@RestController = @Controller + @ResponseBody】
 * @Author: Wangzz
 * @Version: 1.0.0
 * @CreateDate: Created in 2021/9/17 19:36
 * @UpdateDate: [dateFormat:YYYY-MM-DD][modifier][description]
 */
@RestController
public class HelloController {
    @RequestMapping("hi")
    public Object getInfo(){
        return "We are the world!";
    }
}
