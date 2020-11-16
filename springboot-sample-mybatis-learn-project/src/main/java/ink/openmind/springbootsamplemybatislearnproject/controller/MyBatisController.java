package ink.openmind.springbootsamplemybatislearnproject.controller;

import ink.openmind.springbootsamplemybatislearnproject.dao.IUserDao;
import ink.openmind.springbootsamplemybatislearnproject.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/15 10:28
 * DESC
 */
@RestController
public class MyBatisController {

    private final Logger logger = LoggerFactory.getLogger(MyBatisController.class);

    @Autowired
    private IUserDao iUserDao;

    // 查询所有记录
    @GetMapping("/users/mybatis/queryAll")
    public List<User> queryAll(){
        return iUserDao.findAllUsers();
    }

    // 新增一条记录
    @GetMapping("/users/mybatis/insert")
    public Boolean insert(String name, String password){
        logger.error("name: " + name + ", password: " + password);
        if(StringUtils.isEmpty(name) && StringUtils.isEmpty(password)){
            return false;
        }
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        return iUserDao.insertUser(user) > 0;
    }

    // 修改一条记录
    @GetMapping("/users/mybatis/update")
    public Boolean insert(Integer id, String name, String password){
        logger.error("id: " + id + ", name: " + name + ", password：" + password);

        if(id == null || id < 1 || StringUtils.isEmpty(name) || StringUtils.isEmpty(password)){
            return false;
        }
        logger.error("name: " + name + ", password: " + password);
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        logger.error(user.toString());
        return iUserDao.updateUser(user) > 0;
    }

    // 删除一条记录
    @GetMapping("/users/delete")
    public Boolean deleteById(Integer id){
        if(id == null || id < 1){
            return false;
        }
        return iUserDao.deleteUser(id) > 0;
    }
}
