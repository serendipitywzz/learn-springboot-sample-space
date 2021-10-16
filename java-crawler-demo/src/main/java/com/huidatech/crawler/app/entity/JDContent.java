package com.huidatech.crawler.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: JD爬取内容实体
 * @Author: Wangzz
 * @Version: 1.0.0
 * @CreateDate: Created in 2021/10/16 21:21
 * @UpdateDate: [dateFormat:YYYY-MM-DD][modifier][description]
 */

@Data
@NoArgsConstructor // 有参构造
@AllArgsConstructor // 无参构造
public class JDContent {

    private String title; // 图书标题
    private String img; // 图书图片
    private String price; // 图书价格

    // 属性自己添加
}
