package ink.openmind.springbootsamplemybatisproject.controller;

import ink.openmind.springbootsamplemybatisproject.entity.User;
import ink.openmind.springbootsamplemybatisproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/11 19:47
 * DESC
 */
@RestController // @RestController = @ResponseBody + @Controller
@RequestMapping("user") // @RequestMapping = @GetMapping/ @PostMapping
public class UserController {

    /* 注解注入
    @Autowired
    private IUserService iUserService;
    */

    //===============构造器注入======================
    private final IUserService userService;

    @Autowired
    public UserController(IUserService iUserService){
        this.userService = iUserService;
    }

    // 使用post请求新建
    @PostMapping()
    public String save(User user){
        userService.save(user);
        return ">>>Save Success!!!<<<";
    }

    // 使用put请求更新，会拦截类似/user/1这种形式的路径
    @PutMapping("{id}")
    public String update(User user, @PathVariable int id){
        // 当数据不存在时，不允许更新
        if(userService.findById(id) == null){
            return "The aimed data is not exists!";
        }
        // 防止传入的id不一致，如user中id属性是2，而url路径中id为1
        if(user.getId() != id){
            return "Unmatched parameters!";
        }
        userService.update(user);
        return ">>>Update Success!!!<<<";
    }

    // 使用delete请求删除相应数据
    @DeleteMapping("{id}")
    public String delete(@PathVariable int id){
        userService.delete(id);
        return ">>>Delete Success!!!<<<";
    }

    // 使用get方法查询
    @GetMapping("/users")
    public List<User> list(){
        List<User> list = userService.list();
        return list;
    }

    // 使用get方法查询单个数据
    @GetMapping("{id}")
    public User getById(@PathVariable int id){
        return userService.findById(id);
    }


}
