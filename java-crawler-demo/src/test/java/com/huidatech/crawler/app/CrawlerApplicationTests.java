package com.huidatech.crawler.app;

import com.huidatech.crawler.app.entity.User;
import com.huidatech.crawler.app.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class CrawlerApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users1 = userMapper.selectList(null);

    }

}
