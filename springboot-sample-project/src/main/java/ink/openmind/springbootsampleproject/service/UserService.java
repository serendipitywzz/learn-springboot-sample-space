package ink.openmind.springbootsampleproject.service;

import ink.openmind.springbootsampleproject.entity.User;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/11 9:37
 * DESC 定义service层
 */
public interface UserService {
    User save(User user);
}
