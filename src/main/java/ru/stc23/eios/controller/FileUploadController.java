package ru.stc23.eios.controller;

    /**
     * @author Matveev
     * */

import java.io.File;
import java.io.InputStream;
import java.util.Base64;

import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.stc23.eios.model.FileBase64;
import ru.stc23.eios.model.User;
import ru.stc23.eios.repos.FileUploadRepo;
import ru.stc23.eios.service.FileUploadService;


@Controller
public class FileUploadController {


    private final FileUploadRepo fileUploadRepo;

    public FileUploadController(FileUploadRepo fileUploadRepo) {
        this.fileUploadRepo = fileUploadRepo;
    }

    @GetMapping("/upload")
    public String provideUploadInfo() {
        return "/upload";
    }

    @GetMapping("/files")
    public String pf() {
        return "/files";
    }

    @PostMapping("/upload")
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
                                                 @RequestParam("file") MultipartFile file,
                                                 @AuthenticationPrincipal User user){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                Base64.Encoder fileEncoder = Base64.getEncoder();

                FileBase64 fileBase64 = new FileBase64();
                fileBase64.setFilecode(file.getBytes().toString());
                fileBase64.setFilename(file.getName());
//                fileBase64.setUser(user);
                fileUploadRepo.save(fileBase64);


                return "Вы удачно загрузили " + name;
            } catch (Exception e) {
                return "Вам не удалось загрузить " + name + " => " + e.getMessage();
            }
        } else {
            return "Вам не удалось загрузить " + name + " - файл пустой.";
        }
    }
    @PostMapping("/download")
    public @ResponseBody FileBase64 handleFileUpload(@RequestParam("filename") String name) {
        FileBase64 fileBase64 = new FileBase64();

        Base64.Decoder fileDecoder = Base64.getDecoder();
        fileBase64 = (FileBase64) fileUploadRepo.getByFilename(name);

        fileBase64.setFilecode(fileDecoder.decode(fileBase64.getFilecode()).toString());
        MultipartFile file;

        return fileBase64;
    }


}
