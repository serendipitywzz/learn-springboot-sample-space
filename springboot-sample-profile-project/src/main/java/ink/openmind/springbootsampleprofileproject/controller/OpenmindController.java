package ink.openmind.springbootsampleprofileproject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/13 22:17
 * DESC
 */
@RestController
public class OpenmindController {
    @Value("${hello}")
    private String info;

    @RequestMapping("/openmind")
    public String getInfo(){
        return info;
    }
}
