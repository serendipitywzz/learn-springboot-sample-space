package ink.openmind.springbootsamplebaselearnproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/13 23:31
 * DESC
 */
@Controller
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/log")
    @ResponseBody
    public String log(){
        logger.info("【info级别日志】");
        logger.warn("【warn级别日志】");
        logger.error("【error级别日志】");
        logger.debug("【debug级别日志】");
        return "日志打印";
    }
}
