package ink.openmind.springbootsampledockerproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Wangzz
 * @Version: 1.0.0
 * @CreateDate: Created in 2021/3/29 9:11
 * @UpdateDate: [dateFormat:YYYY-MM-DD][modifier][description]
 */
@RestController // @RestController = @Controller + @ResponseBody
public class DockerController {
    @RequestMapping
    public String index(){
        return "Hello Docker";
    }
}
