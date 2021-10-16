package ink.openmind.springbootsampleshirodemoproject.controller;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Description: 配置登录接口以及页面访问接口
 * @Author: Wangzz
 * @Version: 1.0.0
 * @CreateDate: Created in 2021/9/28 21:00
 * @UpdateDate: [dateFormat:YYYY-MM-DD][modifier][description]
 */
@Controller
public class UserController {

    /**
     *  在doLogin方法中，首先构造一个UsernamePasswordToken实例
     *  然后获取一个Subject对象并调用该对象中的login方法执行登录操作
     *  在登录操作执行过程中如果有异常抛出时，说明登录失败，携带错误信息返回登录视图；
     *  等登录成功时则重定向到"/index".
     * */
    @PostMapping("/doLogin")
    public String doLogin(String username, String password, Model model){
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(usernamePasswordToken);
        }catch(AuthenticationException ae){
            model.addAttribute("error", "用户名或密码输入错误！");
        }
        return "redirect:/index";
    }

    /**
     * 暴露两个接口： /admin   和  /user
     * 对于 /admin接口需要具有admin角色才可以访问
     * 对于 /user接口需要具有admin和user角色才可以访问
     * 对于 其他不需要角色就能访问的接口直接在WebMvc中配置即可
     * */

    @RequiresRoles("admin")
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequiresRoles(value = {"admin", "user"}, logical = Logical.OR)
    @GetMapping("/user")
    public String user(){
        return "user";
    }
}
