package ink.openmind.springbootsamplemybatisproject;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/11 20:25
 * DESC 单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootApplication.class)
// 定义单元测试执行顺序，采取测试用例名称升序
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MVCTestUnit01 {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * 保存
     * @throws Exception
     * */
    @Test
    public void test1() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .post("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("id", "4")
                .param("username", "道尔·琼森")
                .param("password", "adminpwd"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(">>>Save Success!!!<<<"))
                .andDo(print());
    }

    /**
     * 查询
     * @throws Exception
     * */
    @Test
    public void test2() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                // 采取内容匹配，要保证查询出来的数据和之前保存的数据是一致的，否则该项单元测试失败！
                .andExpect(MockMvcResultMatchers.content().json(
                        "[{\"id\":1,\"username\":\"道尔·琼森\",\"password\":\"adminpwd\"}]"
                ))
                .andDo(print());
    }

    /**
     * 更新
     * @throws Exception
     * */
    public void test3() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .put("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("username", "王壮")
                .param("password", "密码"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(">>>Update Success!!!<<<"))
                .andDo(print());
        // 验证数据是否正确
        mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        "[{\"id\":1,\"username\":\"test\",\"password\":\"password\"}]"
                )).andDo(print());
    }

    /**
     * 删除
     * @throws Exception
     * */
    @Test
    public void test4() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string(">>>Delete Success!<<<"))
                .andDo(print());
    }
}
