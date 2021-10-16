package ink.openmind.app.controller;

import ink.openmind.app.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Description: BookController
 * @Author: Wangzz
 * @Version: 1.0.0
 * @CreateDate: Created in 2021/9/28 22:31
 * @UpdateDate: [dateFormat:YYYY-MM-DD][modifier][description]
 */
@Controller
public class BookController {
    @GetMapping("/book")
    @ResponseBody
    public Book book(){
        Book book = new Book();
        book.setAuthor("罗贯中");
        book.setName("三国演义");
        book.setPrice(30F);
        book.setPublicationDate(new Date());
        return book;
    }

    // @RestController = @Controller + @ResponseBody
}
