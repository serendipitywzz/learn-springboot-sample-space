package ink.openmind.springbootsampleproject.service.impl;

import ink.openmind.springbootsampleproject.dao.UserRepository;
import ink.openmind.springbootsampleproject.entity.User;
import ink.openmind.springbootsampleproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/11 9:38
 * DESC
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // 添加事务管理
    //@Transactional(rollbackFor = Exception.class)
    @Override
    public User save(User user) {
        // 保存实体类
        userRepository.save(user);
//        // 人为抛出异常
//        int tmp = 1 / 0;
        // 修改密码
        user.setPassword("12test023");
        // 重新保存，更新记录
        return  userRepository.save(user);
    }
}
