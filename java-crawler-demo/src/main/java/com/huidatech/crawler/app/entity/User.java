package com.huidatech.crawler.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: Wangzz
 * @Version: 1.0.0
 * @CreateDate: Created in 2021/10/16 22:42
 * @UpdateDate: [dateFormat:YYYY-MM-DD][modifier][description]
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
