package ink.openmind.springbootsamplemultidatasourceproject.first.service.impl;


import ink.openmind.springbootsamplemultidatasourceproject.first.entity.UserOne;
import ink.openmind.springbootsamplemultidatasourceproject.first.repository.UserOneRepository;
import ink.openmind.springbootsamplemultidatasourceproject.first.service.UserOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/11 14:37
 * DESC
 */
@Service
public class UserOneServiceImpl implements UserOneService {

    @Autowired
    private UserOneRepository userOneRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserOne save(UserOne userOne) {
        return userOneRepository.save(userOne);
    }


}
