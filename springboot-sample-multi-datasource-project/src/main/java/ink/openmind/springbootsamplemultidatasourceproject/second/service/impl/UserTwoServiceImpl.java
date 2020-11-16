package ink.openmind.springbootsamplemultidatasourceproject.second.service.impl;

import ink.openmind.springbootsamplemultidatasourceproject.second.entity.UserTwo;
import ink.openmind.springbootsamplemultidatasourceproject.second.repository.UserTwoRepository;
import ink.openmind.springbootsamplemultidatasourceproject.second.service.UserTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/11 16:13
 * DESC
 */
@Service
public class UserTwoServiceImpl implements UserTwoService {

    @Autowired
    private UserTwoRepository userTwoRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserTwo save(UserTwo userTwo) {
        return userTwoRepository.save(userTwo);
    }
}
