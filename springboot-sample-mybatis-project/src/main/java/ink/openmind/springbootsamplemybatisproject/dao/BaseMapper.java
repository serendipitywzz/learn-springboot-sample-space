package ink.openmind.springbootsamplemybatisproject.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/11 19:13
 * DESC 用于提取常用的公共方法，减少重复代码
 */
@Mapper
public interface BaseMapper<T>{
    /**
     * 保存
     * */
    Integer save(T t);

    /**
     * 删除
     * */
    void delete(Integer id);

    /**
     * 通过id查询
     * */
    T findById(Integer id);

    /**
     * 更新
     * */
    void update(T t);

    /**
     * 返回所有信息
     * */
    List<T> list();

}
