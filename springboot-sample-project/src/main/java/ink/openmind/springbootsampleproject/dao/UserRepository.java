package ink.openmind.springbootsampleproject.dao;

import ink.openmind.springbootsampleproject.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/11 9:36
 * DESC 定义DAO层操作 继承CrudRepository
 */
public interface UserRepository extends CrudRepository<User,Integer> {

}
