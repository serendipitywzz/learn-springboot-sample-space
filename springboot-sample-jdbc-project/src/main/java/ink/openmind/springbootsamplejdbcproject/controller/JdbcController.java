package ink.openmind.springbootsamplejdbcproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/14 22:19
 * DESC
 */
@RestController
public class JdbcController {
    // 自动配置，直接通过@Autowired 注入进来
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 查询所有记录
    @GetMapping("/users/queryAll")
    public List<Map<String, Object>> queryAll(){

        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM tb_user");
        return list;
    }


    // 新建一条记录
    @GetMapping("/users/insert")
    public Object insert(String name, String password){
        if(StringUtils.isEmpty(name) && StringUtils.isEmpty(password)){
            return false;
        }
        String sql = "INSERT INTO tb_user(name,password) VALUES (?,?);";
        jdbcTemplate.update(sql, name, password);
        return true;
    }
}
