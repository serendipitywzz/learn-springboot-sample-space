package ink.openmind.springbootsamplemybatisproject.service;

import java.util.List;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/11 19:34
 * DESC 将Service常用的公共方法抽象出来eg: CRUD等功能减少重复代码
 */
public interface IBaseService<T>{
    /**
     * 保存
     * */
    Integer save(T t);

    /**
     * 删除
     * */
    void delete(Integer id);

    /**
     * 根据id检索相关信息
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
