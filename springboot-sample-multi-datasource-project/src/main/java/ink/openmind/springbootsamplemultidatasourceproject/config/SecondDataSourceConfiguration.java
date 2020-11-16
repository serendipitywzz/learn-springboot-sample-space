package ink.openmind.springbootsamplemultidatasourceproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/11 15:59
 * DESC
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        // 设置Repository所在位置
        basePackages = {
                "ink.openmind.springbootsamplemultidatasourceproject.second.repository"
        },
        // 设置entityManager工厂
        entityManagerFactoryRef = "entityManagerFactorySecond",
        // 设置事务管理器
        transactionManagerRef = "transactionManagerSecond"
)
public class SecondDataSourceConfiguration {
    /**
     * 数据源2
     * */
    private final DataSource secondDataSource;

    /**
     * 构造方法注入
     * */
    @Autowired
    public SecondDataSourceConfiguration(
            @Qualifier("secondDataSource")
            DataSource dataSource)
    {
        this.secondDataSource = dataSource;
    }

    /**
     * 配置entityManager工厂
     * */
    @Bean(name="entityManagerFactorySecond")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecond(EntityManagerFactoryBuilder builder){
        return builder
                // 设置数据源
        .dataSource(secondDataSource)
                // 设置entity的包路径
        .packages("ink.openmind.springbootsamplemultidatasourceproject.second.entity")
        .build();
    }

    /**
     * 配置事务管理器
     * */
    @Bean(name="transactionManagerSecond")
    public PlatformTransactionManager transactionManagerSecond(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(entityManagerFactorySecond(builder).getObject());
    }
}
