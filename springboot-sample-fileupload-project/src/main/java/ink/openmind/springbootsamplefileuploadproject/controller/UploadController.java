package ink.openmind.springbootsamplefileuploadproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/14 20:21
 * DESC
 */
@Controller
public class UploadController {
    // 文件保存路径 /home/project/upload
    // 即当前project目录下的upload文件夹
    private final static String FILE_UPLOAD_PATH = "E:\\SoftDevWorkspace\\JavaEE\\learn-springboot-sample-space\\springboot-sample-fileupload-project\\upload\\";

    /*
    * 由于已经自动配置了MultipartFile,能够直接在控制器方法中使用MultipartFile读取文件信息
    * @RequestParam 中的文件名称需要与文件上传前端设置的name属性一致，如果文件为空则返回上传失败
    * ，如果不为空则生成一个新的文件名，之后读取文件流并写入到指定的上传路径中，最后返回上传成功！
    * */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file")MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败！！！";
        }
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 生成文件名称通用方法
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random random = new Random();
        StringBuilder tempName = new StringBuilder();
        tempName.append(sdf.format(new Date()))
                .append(random.nextInt(100))
                .append(suffixName);
        String newFileName = tempName.toString();

        try {
            // 保存文件
            byte[] bytes = file.getBytes();
            Path path = Paths.get(FILE_UPLOAD_PATH + newFileName);
            Files.write(path, bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传成功！！！" + " => 上传路径: /files/" + newFileName;
    }
}
