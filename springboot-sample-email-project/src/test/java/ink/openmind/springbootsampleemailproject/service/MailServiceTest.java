package ink.openmind.springbootsampleemailproject.service;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/28 13:05
 * DESC
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    private Logger logger = LoggerFactory.getLogger(MailServiceTest.class);

    @Resource
    MailService mailService;

    @Resource
    TemplateEngine templateEngine;

    @Test
    public void sendSimpleMessageMailTest(){
        mailService.sendSimpleMail("1713355078@qq.com","美好的一天从写代码开始！", "夜以继日,继往开来，迭代上升");
    }

    @Test
    public void sendHtmlMessageMailTest(){
        String content = "<html>\n" +
                "<body>\n" +
                "<h3> <font color='dodgerblue'>Hello World, HTML Mail</font></h3>\n" +
                "</body>\n" +
                "</html>\n";
        try {
            mailService.sendHtmlMail("wangzz_smith@126.com","HTML邮件发送测试！",content);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sendHtmlMessageMailWithAttachmentTest(){
        String content = "<html>\n" +
                "<body>\n" +
                "<h3> <font color='dodgerblue'>带附件邮件发送测试</font></h3>\n" +
                "</body>\n" +
                "</html>\n";
        String filePath = "e://music.mp3";
        mailService.sendAttachmentMail("wangzz_smith@126.com", "带有附件邮件测试！", content, filePath);
    }

    @Test
    public void sendInlineResourceTest() throws MessagingException {
        String imgPath = "E:\\SoftDevWorkspace\\JavaEE\\learn-springboot-sample-space\\springboot-sample-email-project\\src\\main\\resources\\static\\images\\bg02.png";
        String rscId = "img001";
        String content = "<html>\n" +
                "<body>\n" +
                "<h3> <img src=\'cid:"+rscId+"\'></img><font color='dodgerblue'>图片邮件发送测试</font></h3>\n" +
                "</body>\n" +
                "</html>\n";
        mailService.sendInlineResource("wangzz_smith@126.com", "带有图片邮件发送测试", content, imgPath, rscId);
    }

    @Test
    public void sentMailWithTemplateTest(){
        Context context = new Context();
        context.setVariable("id", "006");

        String emailContent = templateEngine.process("email_template", context);

        try {
            mailService.sendHtmlMail("wangzz_smith@126.com", "模板邮件测试！", emailContent);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sendMessageWithDynamicArgsTest() throws UnsupportedEncodingException, MessagingException {
        Assert.assertNotNull(mailService);
        mailService.sendSimpleMailWithDynamicArgs("1713355078@qq.com","致自己-愿无悔青春！",
                "千里之堤溃于蚁穴！九层之台起于垒土");
        //mailService.sendSimpleMail("1713355078@qq.com","【Do anything step by step】","人无远虑，必有近忧");
    }

    @Test
    public void getInfo() {
        System.out.println();
    }
}