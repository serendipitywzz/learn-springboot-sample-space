package ink.openmind.springbootsamplemybatisproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 扫描mapper接口位置
@MapperScan(basePackages = {"ink.openmind.springbootsamplemybatisproject.dao"})
public class SpringbootSampleMybatisProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSampleMybatisProjectApplication.class, args);
    }

}
