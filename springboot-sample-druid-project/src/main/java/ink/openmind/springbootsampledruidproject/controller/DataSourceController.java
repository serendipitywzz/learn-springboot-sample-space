package ink.openmind.springbootsampledruidproject.controller;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/14 23:05
 * DESC 配置是否已经使得数据源切换为Druid数据源，新建一个DataSourceController类进行验证
 */
@RestController
public class DataSourceController {
    // 自动配置，可以直接通过@Autowired注入进来
    @Autowired
    private DataSource dataSource;

    // 查询数据源信息
    @GetMapping("/getdatasource")
    public Map<String, Object> datasource() throws SQLException {
        Map result = new HashMap();
        result.put("数据源类名", dataSource.getClass() + "");
        // 获取数据库连接对象
        Connection connection = dataSource.getConnection();
        // 判断连接对象是否为空
        result.put("能否正确获得连接", connection != null);
        connection.close();
        return result;
        // {"数据源类名":"class com.alibaba.druid.pool.DruidDataSource","能否正确获得连接":true}
    }

    // 查看数据源其他配置信息
    @GetMapping("/getdatasourceinfo")
    public Map<String,Object> datasource2() throws SQLException{
        DruidDataSource druidDataSource = (DruidDataSource)dataSource;
        Map result = new HashMap();
        result.put("数据源类名", druidDataSource.getClass() + "");
        // 获取数据库连接对象
        Connection connection = druidDataSource.getConnection();
        // 判断连接对象是否为空
        result.put("是否正确获得连接🔗", connection != null);
        result.put("initialiSize值为",druidDataSource.getInitialSize());
        result.put("maxActive值为",druidDataSource.getMaxActive());
        result.put("minIdle值为",druidDataSource.getMinIdle());
        result.put("validationQuery值为",druidDataSource.getValidationQuery());
        result.put("maxWait值为",druidDataSource.getMaxWait());
        connection.close();
        return result;
    }
}

/*
* 在控制器中注入DataSource对象，并查看实现类的类名，该DataSource对象获取连接对象
* */