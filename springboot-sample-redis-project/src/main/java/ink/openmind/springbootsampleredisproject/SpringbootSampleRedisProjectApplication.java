package ink.openmind.springbootsampleredisproject;

import ink.openmind.springbootsampleredisproject.entity.Emp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//排除自动配置
@RestController // @RestController = @ResponseBody + @Controller
@RequestMapping(value = "redisdemo")
public class SpringbootSampleRedisProjectApplication {

    private final Log log = LogFactory.getLog(SpringBootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSampleRedisProjectApplication.class, args);
    }

//    @GetMapping("{id}") // 根据id查询指定对象
//    public Emp getInfo(@PathVariable int id){
//        if(id == 200){
//            // 创建一个Emp对象将其解析为JSON信息格式的文本
//            Emp emp = new Emp();
//            emp.setEmpName("王壮壮");
//            emp.setEmpAge(21);
//            emp.setEmpSal(8762.56);
//            emp.setHireDate(new Date());
//            return emp;
//        }
//        return null;
//    }
//    @PostMapping()// 添加对象
//    public String printInfo(Emp emp){
//        log.error(emp.toString());
//        return "【add - info】" + emp.toString();
//    }
//
//    @DeleteMapping("{id}") // 模拟删除指定对象
//    public String deleteInfo(@PathVariable int id){
//        return "【delete -info】 -> " + id;
//    }
//
//    @PutMapping("{id}")
//    public String updateInfo(@PathVariable int id){
//        if(id == 200){
//            log.info("数据存在");
//            return "数据已经更新！";
//        }else{
//            log.error("数据不存在！");
//            return "数据更新失败！";
//        }
//    }

}
