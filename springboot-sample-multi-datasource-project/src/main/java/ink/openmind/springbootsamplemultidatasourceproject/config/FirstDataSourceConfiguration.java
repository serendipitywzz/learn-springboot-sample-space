package ink.openmind.springbootsamplemultidatasourceproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/11 13:16
 * DESC
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        // 设置Repository所在位置📍
        basePackages = {
                "ink.openmind.springbootsamplemultidatasourceproject.first.repository"
        },
        // 设置entityManager工厂
        entityManagerFactoryRef = "entityManagerFactoryFirst",
        // 设置事务管理器
        transactionManagerRef = "transactionManagerFirst"
)
public class FirstDataSourceConfiguration {
    /**
     * 数据源1
     * */
    private final DataSource firstDataSource;

    /**
     * 构造方法注入依赖
     * */
    @Autowired
    public FirstDataSourceConfiguration(
            @Qualifier("firstDataSource")
                    DataSource firstDataSource)
    {
        this.firstDataSource = firstDataSource;
    }

    /**
     * 配置entityManager工厂
     * */
    @Primary
    @Bean(name = "entityManagerFactoryFirst")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryFirst(EntityManagerFactoryBuilder builder){
        return builder
                // 设置数据源
                .dataSource(firstDataSource)
                // 设置entity的包路径
                .packages("ink.openmind.springbootsamplemultidatasourceproject.first.entity")
                .build();
    }

    /**
     * 配置事务管理器
     * */
    @Primary
    @Bean(name = "transactionManagerFirst")
    public PlatformTransactionManager transactionManagerFirst(EntityManagerFactoryBuilder builder){
        // 返回 jpa 事务管理器
        return new
                JpaTransactionManager(entityManagerFactoryFirst(builder).getObject());
    }

}
