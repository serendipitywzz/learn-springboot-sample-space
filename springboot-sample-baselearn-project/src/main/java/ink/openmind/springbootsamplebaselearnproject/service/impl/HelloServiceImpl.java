package ink.openmind.springbootsamplebaselearnproject.service.impl;

import ink.openmind.springbootsamplebaselearnproject.service.IHelloService;
import org.springframework.stereotype.Service;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/14 9:33
 * DESC
 */
@Service // @Service将当前类自动加载到Spring容器中成为业务组件
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String name){
        return "Hello => " + name;
    }
}
