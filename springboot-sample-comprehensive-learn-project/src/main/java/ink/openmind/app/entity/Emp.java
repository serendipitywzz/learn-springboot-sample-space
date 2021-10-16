package ink.openmind.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Description:
 * @Author: Wangzz
 * @Version: 1.0.0
 * @CreateDate: Created in 2021/9/17 19:50
 * @UpdateDate: [dateFormat:YYYY-MM-DD][modifier][description]
 */
@Data
public class Emp {
    private String username;
    @JsonInclude(JsonInclude.Include.NON_NULL) // 当该字段为空的时候则不返回此字段
    private String age;
    @JsonIgnore // 在Jackson形式返回的json数据中不包含此字段(info)
    private String info;
    @JsonFormat(pattern = "yyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date birthday;
}
