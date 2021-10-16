package ink.openmind.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Description: Book
 * @Author: Wangzz
 * @Version: 1.0.0
 * @CreateDate: Created in 2021/9/28 22:30
 * @UpdateDate: [dateFormat:YYYY-MM-DD][modifier][description]
 */
@Data
public class Book {
    private String name;
    private String author;
    @JsonIgnore
    private Float price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private Date publicationDate;
}
