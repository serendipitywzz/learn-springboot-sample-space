package ink.openmind.springbootsamplemybatislearnproject.controller;

import ink.openmind.springbootsamplemybatislearnproject.service.TransactionTestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/15 12:56
 * DESC
 */

/**
 * 实现一个控制器处理/transactionTest请求
 * 方法中会进行业务层test1()方法和test2()方法的调用
 * */
@Controller
public class TransactionTestController {
    @Resource
    private TransactionTestService transactionTestService;

    // 事务管理测试
    @GetMapping("/transactionTest")
    @ResponseBody
    public String transactionTest(){
        // test1未添加@Transactional注解
        transactionTestService.test1(); // 通过
        // test2添加了@Transaction注解
        transactionTestService.test2(); // 失败
        return "请求完成 >>>>>";
    }

}
