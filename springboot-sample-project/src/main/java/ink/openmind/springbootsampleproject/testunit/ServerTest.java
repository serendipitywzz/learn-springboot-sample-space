package ink.openmind.springbootsampleproject.testunit;

import ink.openmind.springbootsampleproject.entity.User;
import ink.openmind.springbootsampleproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/11 9:43
 * DESC
 */
@Component // @Component标注类可以被Spring扫描称为Bean组件

/*
* ApplicationRunner 接口可以在SpringBoot启动后马上执行想要执行的方法
* */
public class ServerTest implements ApplicationRunner {

    // Spring容器注入服务类UserService
    @Autowired
    private UserService userService;
    /**
     * 该方法在SpringBoot启动完成后立即执行
     * @param args
     * @throws Exception
     * */
    @Override
    public void run(ApplicationArguments args){
        // 新建一个实体类
        User user = new User();
        user.setUsername("王壮");
        user.setPassword("wz123456");
        // 调用包存在实体类的service
        userService.save(user);
    }
}
