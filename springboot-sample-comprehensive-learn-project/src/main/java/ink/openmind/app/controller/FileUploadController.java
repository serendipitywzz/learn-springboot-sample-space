package ink.openmind.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Description: 文件上传控制器
 * @Author: Wangzz
 * @Version: 1.0.0
 * @CreateDate: Created in 2021/9/28 23:15
 * @UpdateDate: [dateFormat:YYYY-MM-DD][modifier][description]
 */
@RestController
public class FileUploadController {
    private static  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest request){
        String realPath =
                request.getSession().getServletContext().getRealPath("/uploadFile/");
        String format = sdf.format(new Date());
        File folder = new File(realPath + format);
        if(!folder.isDirectory()){
            folder.mkdirs();
        }
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString()
                + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        try{
            uploadFile.transferTo(new File(folder, newName));
            String filePath = request.getScheme() + "://" + request.getServerName()
                    + " : " + request.getServerPort() + "/uploadFile/" + format + newName;
            return filePath;
        }catch(IOException e){
            e.printStackTrace();
        }
        return "UPLOAD FAILURE!!!";
    }

}
