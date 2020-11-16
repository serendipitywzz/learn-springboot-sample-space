package ink.openmind.springbootsamplejspproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/14 15:49
 * DESC
 */
@Controller
public class JSPController {
    @RequestMapping("/printinfo")
    public String printInfo(Model model){
        System.out.println("Coming .............");

        model.addAttribute("info","We are the world");

        return "index";

    }
}
