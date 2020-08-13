package ru.stc23.eios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.stc23.eios.model.FileBase64;
import ru.stc23.eios.model.User;
import ru.stc23.eios.service.FileUploadService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class FileDownLoadController2 {

    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        FileBase64 fileBase64 = fileUploadService.getFile(fileName);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileBase64.getFiletype()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileBase64.getFilename() + "\"")
                .body(new ByteArrayResource(fileBase64.getFilecode().getBytes()));
        //todo наиписать инкод
    }

    @GetMapping("/download")
    public String fileList(Model model) {
        model.addAttribute("files", fileUploadService.getAllFiles());
        return "files";
    }
}
