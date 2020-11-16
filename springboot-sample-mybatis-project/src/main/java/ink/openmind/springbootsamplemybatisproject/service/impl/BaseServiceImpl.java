package ink.openmind.springbootsamplemybatisproject.service.impl;

import ink.openmind.springbootsamplemybatisproject.dao.BaseMapper;
import ink.openmind.springbootsamplemybatisproject.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/11 19:40
 * DESC
 */
@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    @Autowired
    protected BaseMapper<T> baseMapper;


    @Override
    public Integer save(T t) {
        Integer state = baseMapper.save(t);
        return state;
    }

    @Override
    public void delete(Integer id) {
        baseMapper.delete(id);
    }

    @Override
    public T findById(Integer id) {
        T obj = baseMapper.findById(id);
        return obj;
    }

    @Override
    public void update(T t) {
        baseMapper.update(t);
    }

    @Override
    public List<T> list() {
        List<T> listObj = baseMapper.list();
        return listObj;
    }
}
