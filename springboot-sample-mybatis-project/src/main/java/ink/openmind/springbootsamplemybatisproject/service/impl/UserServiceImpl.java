package ink.openmind.springbootsamplemybatisproject.service.impl;

import ink.openmind.springbootsamplemybatisproject.entity.User;
import ink.openmind.springbootsamplemybatisproject.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/11 19:45
 * DESC UserServiceImpl.java用于实现和User有关的业务逻辑
 * 如果BaseServiceImpl.java提供的公共增删查共功能无法满足要求可以直接覆盖或新填一个方法
 */
@Service //@Service将当前类标记的Spring容器的中业务组件
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

}
