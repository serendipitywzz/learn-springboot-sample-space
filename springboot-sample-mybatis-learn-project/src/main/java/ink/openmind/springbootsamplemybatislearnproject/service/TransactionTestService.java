package ink.openmind.springbootsamplemybatislearnproject.service;

import ink.openmind.springbootsamplemybatislearnproject.dao.IUserDao;
import ink.openmind.springbootsamplemybatislearnproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/15 12:44
 * DESC
 */
@Service
public class TransactionTestService {

    @Autowired
    private IUserDao iUserDao;

    public Boolean test1(){
        User user = new User();
        user.setPassword("test1 - password");
        user.setName("Hi, nice to meet you! 我肯定能通过因为我没有进行事务控制");
        // 在数据库新增一条记录
        iUserDao.insertUser(user);
        // 发生异常
        int temp  = 1 / 0;
        return true;
    }

    @Transactional
    public Boolean test2(){
        User user = new User();
        user.setPassword("test2 - password");
        user.setName("我肯定无法通过，因为我进行了事务控制");
        // 在数据库中新增一条记录
        iUserDao.insertUser(user);
        // 发生异常
        int temp = 1 / 0;
        return true;
    }
}
