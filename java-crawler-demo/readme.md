
# Java爬虫

> 数据问题? 数据库获取，消息队列中获取中，都可以成为数据源


爬取数据： 获取请求返回的页面信息，筛选出来我们想要的数据即可！

所有的学不会都是给懒找借口！！！


# MyBatisPlus的使用

### MyBatisPlus概述


> MP可以节省大量工作时间，所有的CRUD代码都可以自动化完成

#### MyBatisPlus是什么

> 使用第三方组件
> 1. 导入对应的依赖
> 2. 研究依赖如何配置
> 3. 代码如何编
> 4. 提高和扩展

## 入门

#### 1. 创建数据库
```sql


DROP TABLE IF EXISTS user;

CREATE TABLE user
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	age INT(11) NULL DEFAULT NULL COMMENT '年龄',
	email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
	PRIMARY KEY (id)
);


DELETE FROM user;

INSERT INTO user (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');
```

#### 2. 使用MyBatis-Plus注意事项

1. MP可以节省大量代码但不要同时导入mybatis和mybatis-plus
2. mysql5和mysql8驱动不同而且mysql8还要增加时区的配置

```properties

# mysql5 驱动不同 => com.mysql.jdbc.Driver
# mysql8 驱动不同 => com.mysql.cj.jdbc.Driver 还要增加时区配置 serverTimezone=GMT%2B8
spring.datasource.url=jdbc:mysql://localhost:3306/bootlearn?serverTimezone=Asia/Shanghai&allowMultiQueries=true
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=mysqladmin
```


#### 3.开发方式

```text
 传统方式: entity - DAO(Database Access Object - 链接mybatis、配置mapper.xml文件) - service - controller
 使用MP之后
 * entity
 * mapper接口
 * 使用
```