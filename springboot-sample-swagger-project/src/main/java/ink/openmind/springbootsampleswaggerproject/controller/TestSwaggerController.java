package ink.openmind.springbootsampleswaggerproject.controller;

import ink.openmind.springbootsampleswaggerproject.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/16 8:59
 * DESC
 */
@RestController
public class TestSwaggerController {
    static Map<Integer, User> userMap = Collections.synchronizedMap(new HashMap<Integer, User>());

    // 初始化userMap
    static{
        User user01 = new User();
        user01.setId(1);
        user01.setUsername("openmind.ink");
        user01.setPassword("testpwd");
        User user02 = new User();
        user02.setId(2);
        user02.setUsername("Wangzz");
        user02.setPassword("testwhoweare");
        userMap.put(1, user01);
        userMap.put(2, user02);
    }

    @ApiOperation(value = "获取用户列表", notes = "")
    @GetMapping("/users")
    public List<User> getUserList(){
        List<User> users = new ArrayList<User>(userMap.values());
        return users;
    }

    @ApiOperation(value = "新增用户", notes = "根据User对象新增用户！")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @PostMapping("/users")
    public String postUser(@RequestBody User user){
        userMap.put(user.getId(), user);
        return ">>>新增成功！！！<<<";
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "int")
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Integer id){
        return userMap.get(id);
    }

    @ApiOperation(value = "更新用户详细信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    })
    @PutMapping("/users/{id}")
    public String putUser(@PathVariable Integer id, @RequestBody User user){
        User tempUser = userMap.get(id);
        tempUser.setUsername(user.getUsername());
        tempUser.setPassword(user.getPassword());
        userMap.put(id, tempUser);
        return ">>>更新成功!!!<<<";
    }


    @ApiOperation(value = "删除用户", notes = "根据id删除对象")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "int")
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Integer id){
        userMap.remove(id);
        return ">>>删除成功!!!<<<";
    }
}

/*
* 新增一个controller类定义5个接口，并且每个接口上通过@ApiOperation注解来给API增加说明
* 通过@ApiImplicitParams、@ApiImplicitParam注解来给参数新增说明
* */