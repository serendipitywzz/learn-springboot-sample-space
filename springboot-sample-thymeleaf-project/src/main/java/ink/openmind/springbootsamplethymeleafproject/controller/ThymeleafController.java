package ink.openmind.springbootsamplethymeleafproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/14 18:37
 * DESC 将模板文件所需要的desciption字段赋值并转发至模板文件
 */
@Controller
public class ThymeleafController {
    @GetMapping("/attributes")
    public String attributes(ModelMap modelMap){
        // 更改h1内容
        modelMap.put("title", "Thymeleaf标签演示");
        // 更改 id、name、value
        modelMap.put("th_id", "thymeleaf-input");
        modelMap.put("th_name", "thymeleaf-input");
        modelMap.put("th_value", 13);
        // 更改class、hre
        modelMap.put("th_class", "thymeleaf-class");
        modelMap.put("th_href", "http://12blog.site");
        return "attributes";
    }

    @GetMapping("/thymeleaf")
    public String hello(
            HttpServletRequest httpServletRequest,
            @RequestParam(value = "description",required = false, defaultValue = "SpringBoot集成Thymeleaf")String description)
    {
        httpServletRequest.setAttribute("description", description);
        return "thymeleaf-demo";
    }
}
