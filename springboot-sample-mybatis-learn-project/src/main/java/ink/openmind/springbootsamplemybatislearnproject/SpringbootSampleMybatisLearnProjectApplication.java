package ink.openmind.springbootsamplemybatislearnproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
/*
*  在启动类中添加Mapper包扫描@MapperScan， SpringBoot启动时会自动加载包路径下的Mapper接口
*  也可以直接在每个Mapper接口上面添加@Mapper注解，但是如果Mapper接口数量过多，在每个Mapper添加注解繁琐
*  建议使用扫描注解
* */
@MapperScan("ink.openmind.springbootsamplemybatislearnproject.dao")
public class SpringbootSampleMybatisLearnProjectApplication {
    public static void main(String[] args) {
        System.out.println("启动SpringBoot...");
        SpringApplication.run(SpringbootSampleMybatisLearnProjectApplication.class, args);
    }

}
