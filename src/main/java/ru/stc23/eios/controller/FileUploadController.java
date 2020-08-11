package ru.stc23.eios.controller;

    /**
     * @author Matveev
     * */

import java.util.Base64;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.stc23.eios.model.FileBase64;
import ru.stc23.eios.repos.FileUploadRepo;


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
                String fileName = file.getName();

                FileBase64 fileBase64 = null;
                fileBase64.setFilecode(fileEncoder.encodeToString(bytes));
                fileBase64.setFilename(file.getName());
                fileUploadRepo.save(fileBase64);


                return "Вы удачно загрузили " + name + " в " + name + "-uploaded !";
            } catch (Exception e) {
                return "Вам не удалось загрузить " + name + " => " + e.getMessage();
            }
        } else {
            return "Вам не удалось загрузить " + name + " потому что файл пустой.";
        }
    }



}
