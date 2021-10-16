package ink.openmind.springbootsampleshirodemoproject.controller;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: 设置全局异常处理器
 * @Author: Wangzz
 * @Version: 1.0.0
 * @CreateDate: Created in 2021/9/28 21:12
 * @UpdateDate: [dateFormat:YYYY-MM-DD][modifier][description]
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(AuthorizationException.class)
    public ModelAndView error(AuthorizationException e){
        ModelAndView mv = new ModelAndView("unauthorized");
        mv.addObject("error", e.getMessage());
        return mv;
    }

}
