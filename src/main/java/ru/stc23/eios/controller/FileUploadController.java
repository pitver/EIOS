package ru.stc23.eios.controller;

    /**
     * @author Matveev
     * */

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

import jdk.internal.net.http.ResponseBodyHandlers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.stc23.eios.model.FileBase64;


@Controller
public class FileUploadController {


    @GetMapping("/upload")
    public String provideUploadInfo() {
        return "/upload";
    }

    @PostMapping("/upload")
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
                                                 @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                Base64.Encoder fileEncoder = Base64.getEncoder();
                fileEncoder.encode(bytes);
//                BufferedOutputStream stream =
//                        new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
//                stream.write(bytes);
//                stream.close();
                file.getName();
                FileBase64 fileBase64 = null;
                fileBase64.setFilecode(fileEncoder.encodeToString(bytes));
                fileBase64.setFilename(file.getName());



                return "Вы удачно загрузили " + name + " в " + name + "-uploaded !";
            } catch (Exception e) {
                return "Вам не удалось загрузить " + name + " => " + e.getMessage();
            }
        } else {
            return "Вам не удалось загрузить " + name + " потому что файл пустой.";
        }
    }

}
