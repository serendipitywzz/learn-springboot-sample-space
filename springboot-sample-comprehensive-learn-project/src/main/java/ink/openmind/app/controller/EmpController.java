package ink.openmind.app.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import ink.openmind.app.entity.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: Wangzz
 * @Version: 1.0.0
 * @CreateDate: Created in 2021/9/17 19:51
 * @UpdateDate: [dateFormat:YYYY-MM-DD][modifier][description]
 */
@Controller
public class EmpController {

    @GetMapping("/emp/all")
    public @ResponseBody Emp getEmp(){
        Emp emp = new Emp();
        emp.setUsername("wzz");
        emp.setAge("-22-wjx");
        emp.setInfo("We are the world");
        return emp;
    }

    @GetMapping("/emp/ignoreinfo")
    public @ResponseBody Emp getEmpIgnoreInfo() throws ParseException {
        Emp emp = new Emp();
        emp.setUsername(" - Wyt - ");
        emp.setAge("22");
        emp.setInfo("i'ly");
        String birthday = "1999-05-18";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(birthday);
        emp.setBirthday(parse);
        return emp;
    }
}
