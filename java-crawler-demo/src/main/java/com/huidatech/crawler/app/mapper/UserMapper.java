package com.huidatech.crawler.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huidatech.crawler.app.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: Wangzz
 * @Version: 1.0.0
 * @CreateDate: Created in 2021/10/16 22:43
 * @UpdateDate: [dateFormat:YYYY-MM-DD][modifier][description]
 */
// 在对应的Mapper上面实现基本的类BaseMapper
@Repository // @Repository表示该类是持久层组件
public interface UserMapper extends BaseMapper<User> {
    // 此时所有的CRUD操作已经完成
}
