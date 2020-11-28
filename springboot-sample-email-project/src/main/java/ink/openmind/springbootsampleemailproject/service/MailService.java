package ink.openmind.springbootsampleemailproject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.Properties;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/27 21:26
 * DESC
 */
@Service
public class MailService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.mail.username}")
    private String from;

    @Resource
    private JavaMailSender javaMailSender;


    public MailService() throws MessagingException {
    }

    /**
     * 发送简单邮件
     * @param to 收件人邮箱
     * @param subject 邮件主题
     * @param content 邮件内容
     * */
    public void sendSimpleMail(String to, String subject, String content){
        // 创建发送端
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        // 执行邮件发送
        javaMailSender.send(simpleMailMessage);
    }

    /**
     * 发送HTML邮件
     * @param to 收件人邮箱
     * @param subject 邮件主题
     * @param content 邮件内容
     * */
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(content,true);
        javaMailSender.send(mimeMessage);
    }

    /**
     * 发送带附件邮件
     * @param to 收件人邮箱
     * @param subject 邮箱主题
     * @param content 邮箱内容
     * @param filePath 附件地址
     * */
    public void sendAttachmentMail(String to, String subject, String content, String filePath){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content,true);

            FileSystemResource fileSystemResource = new FileSystemResource(new File(filePath));
            String fileName = fileSystemResource.getFilename();
            mimeMessageHelper.addAttachment(fileName,fileSystemResource);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param to 收件人邮箱
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param rscPath 图片资源地址
     * @param rscId 图片Id
     * */
    public void sendInlineResource(String to, String subject, String content, String rscPath, String rscId){

        logger.warn("发送邮件开始: {},{},{},{},{}",to,subject,content,rscPath,rscId);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content, true);

            FileSystemResource fileSystemResource = new FileSystemResource(new File(rscPath));
            mimeMessageHelper.addInline(rscId, fileSystemResource); // addInline(图片Id, 图片资源路径)
            logger.warn("发送成功！");
        } catch (MessagingException e) {
            logger.warn("发送失败! ");
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);

    }


    public void sendSimpleMailWithDynamicArgs(String to,
                                             String subject,
                                             String message) throws MessagingException, UnsupportedEncodingException {
        // ******************************发送端配置***********************************
        JavaMailSenderImpl jms = new JavaMailSenderImpl();
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        //邮箱的发送服务器地址
        props.setProperty("mail.smtp.host", "smtp.openmind.ink");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        //邮箱发送服务器端口,这里设置为465端口
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        final String username = "admin@openmind.ink";
        final String password = "Woaini1314forever";
        jms.setUsername(username);
        jms.setPassword(password);
        //获取到邮箱会话,利用匿名内部类的方式,将发送者邮箱用户名和密码授权给jvm
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        jms.setJavaMailProperties(props);

        // *****************************建立邮件****************************************
        MimeMessage mimeMailMessage = jms.createMimeMessage();
        MimeMessageHelper helper;
        helper = new MimeMessageHelper(mimeMailMessage, true);
        helper.setFrom(from,"Wangzhaung2-软件工程师"); // sender自定义显示发件人名称
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(message);
        jms.send(mimeMailMessage);
    }

    public String getInfo(){
        return "test";
    }
}
