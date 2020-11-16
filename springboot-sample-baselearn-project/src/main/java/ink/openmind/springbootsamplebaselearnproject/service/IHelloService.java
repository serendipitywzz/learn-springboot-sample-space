package ink.openmind.springbootsamplebaselearnproject.service;

import org.springframework.stereotype.Service;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/14 9:32
 * DESC
 */
@Service
public interface IHelloService {
    String sayHello(String name);
}
