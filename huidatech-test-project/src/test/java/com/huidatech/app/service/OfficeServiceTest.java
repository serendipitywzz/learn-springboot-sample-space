package com.huidatech.app.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: Wangzz
 * @Version: 1.0.0
 * @CreateDate: Created in 2021/9/29 22:28
 * @UpdateDate: [dateFormat:YYYY-MM-DD][modifier][description]
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OfficeServiceTest {

    @Autowired
    private OfficeService officeService;

    @Test
    public void getOfficeNameByOfficeId(){
        String officeName = officeService.getOfficeNameByOfficeId("3b3e7e71b71e44abb37eb792ba8ba8ad");
        Assert.assertEquals(officeName, "惠达合作社");
    }
}