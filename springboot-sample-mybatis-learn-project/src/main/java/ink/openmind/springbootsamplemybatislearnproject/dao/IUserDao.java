package ink.openmind.springbootsamplemybatislearnproject.dao;

import ink.openmind.springbootsamplemybatislearnproject.entity.User;

import java.util.List;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/15 10:17
 * DESC
 */
public interface IUserDao {
    /**
     * 返回数据列表
     * */
    List<User> findAllUsers();

    /**
     * 添加
     * */
    int insertUser(User user);

    /**
     * 更新
     * */
    int updateUser(User user);

    /**
     * 删除
     * */
    int deleteUser(Integer id);

}
