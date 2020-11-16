package ink.openmind.springbootsampleproject.controller;

import ink.openmind.springbootsampleproject.SpringbootSampleProjectApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/10 23:05
 * DESC
 */
/**
 * 此时不用@RestController(@Controller+@ResponseBody)
 * 因为我们接下来要返回视图不能全部都是@ResponseBody
 * */
@Controller
public class DemoController {

    private Log log = LogFactory.getLog(DemoController.class);

    // 使用@Value注解注入属性值
    @Value("${project.info}")
    private String projectInfo;

    @RequestMapping(value = "printinfo")
    @ResponseBody
    public String printInfo(@RequestParam(value="info", defaultValue = "China number one!")String info){
        log.info("info : " + info);
        return  projectInfo + ">>> " + info + " <<<" + "为什么乱码？";
    }
    @RequestMapping(value = "index")
    public String jumpToIndexPage(){
        return "index";
    }
}
