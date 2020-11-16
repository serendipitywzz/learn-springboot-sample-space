package ink.openmind.springbootsamplemultidatasourceproject.first.repository;

import ink.openmind.springbootsamplemultidatasourceproject.first.entity.UserOne;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/11 14:36
 * DESC 定义DAO层操作 继承CrudRepository
 */
public interface UserOneRepository extends CrudRepository<UserOne, Integer> {

}
