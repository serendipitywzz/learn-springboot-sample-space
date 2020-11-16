package ink.openmind.springbootsamplemybatisproject.dao;

import ink.openmind.springbootsamplemybatisproject.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/11 19:15
 * DESC 如果BaseMapper.java中的方法无法满足需求，则直接在UserMapper.java中添加对应的方法即可
 */
@Mapper
public interface UserMapper extends BaseMapper<User>{

}
