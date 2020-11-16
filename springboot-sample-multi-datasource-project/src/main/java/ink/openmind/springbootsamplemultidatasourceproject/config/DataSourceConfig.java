package ink.openmind.springbootsamplemultidatasourceproject.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/11 12:58
 * DESC 数据源配置
 */
@Configuration
public class DataSourceConfig {
    //***********************************************主数据源配置*********************************************************
    @Bean
    @Primary // 该注解表示为主数据源
    @ConfigurationProperties(prefix = "app.datasource.first") // 读取前缀为app.datasource.first的属性
    public DataSourceProperties firstDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "app.datasource.first")
    public DataSource firstDataSource(){
        return firstDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }
    //***********************************************次数据源配置*********************************************************
    @Bean // 这是第二个数据源不能添加@Primary注解
    @ConfigurationProperties(prefix = "app.datasource.second")
    public DataSourceProperties secondDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "app.datasource.second")
    public DataSource secondDataSource(){
        return secondDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

}
