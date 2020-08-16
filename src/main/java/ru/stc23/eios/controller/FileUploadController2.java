package ru.stc23.eios.controller;

import java.nio.file.FileAlreadyExistsException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.stc23.eios.exception.FileStorageException;
import ru.stc23.eios.model.FileBase64;
import ru.stc23.eios.model.Responce;
import ru.stc23.eios.model.User;
import ru.stc23.eios.service.FileUploadService;

@Controller
public class FileUploadController2 {

    @Autowired
    private FileUploadService fileUploadService;


    @GetMapping("/upload")
    public String provideUploadInfo(Model model) {
        return "/upload";
    }

    @PostMapping("/upload")
    public Responce uploadFile(@RequestParam("file") MultipartFile file, @AuthenticationPrincipal User user) {

            FileBase64 file1 =  fileUploadService.getFile(file.getName());

                FileBase64 filename = fileUploadService.storeFile(file);
                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/downloadFile/")
                        .path(filename.getFilename())
                        .toUriString();

                return new Responce(filename.getFilename(), fileDownloadUri,
                        file.getContentType(), file.getSize());

    }

    @PostMapping("/uploadMultipleFiles")
    public List < Responce > uploadMultipleFiles(@RequestParam("files") MultipartFile[] files, @AuthenticationPrincipal User user) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file, user))
                .collect(Collectors.toList());
    }






}
