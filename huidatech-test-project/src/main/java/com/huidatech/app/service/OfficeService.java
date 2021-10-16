package com.huidatech.app.service;

import com.huidatech.app.dao.mapper.OfficeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Description: Office相关的业务逻辑
 * @Author: Wangzz
 * @Version: 1.0.0
 * @CreateDate: Created in 2021/9/29 22:20
 * @UpdateDate: [dateFormat:YYYY-MM-DD][modifier][description]
 */
public class OfficeService {
    @Autowired
    private OfficeMapper officeMapper;

    public String getOfficeNameByOfficeId(String officeId){
        return officeMapper.getOfficeNameByOfficeId(officeId);
    }
}
