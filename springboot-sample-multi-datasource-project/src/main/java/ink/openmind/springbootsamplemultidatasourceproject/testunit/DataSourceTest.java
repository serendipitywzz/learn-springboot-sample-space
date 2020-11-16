package ink.openmind.springbootsamplemultidatasourceproject.testunit;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/11 14:45
 * DESC
 */
import ink.openmind.springbootsamplemultidatasourceproject.first.entity.UserOne;
import ink.openmind.springbootsamplemultidatasourceproject.first.service.UserOneService;
import ink.openmind.springbootsamplemultidatasourceproject.second.entity.UserTwo;
import ink.openmind.springbootsamplemultidatasourceproject.second.service.UserTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * ApplicationRunner 接口可以让SpringBoot启动后马上执行要执行的方法
 * */
@Component
public class DataSourceTest implements ApplicationRunner {

    @Autowired // SpringBoot容器将相关依赖注入
    private UserOneService userOneService;

    @Autowired // SpringBoot容器将相关依赖注入
    private UserTwoService userTwoService;



    @Override
    public void run(ApplicationArguments args) throws Exception {
        // ******************使用第一个数据源 test1********************************
        // 新建一个实体类
        UserOne userOne = new UserOne();
        userOne.setUsername("Donald Trump");
        userOne.setPassword("testpassword!");

        // 调用Service
        userOneService.save(userOne);
        // ******************使用第二个数据源 test2********************************
        // 新建一个实体类
        UserTwo userTwo = new UserTwo();
        userTwo.setUsername("王壮壮");
        userTwo.setPassword("Hello World!");
        // 调用Service
        userTwoService.save(userTwo);

    }
}
