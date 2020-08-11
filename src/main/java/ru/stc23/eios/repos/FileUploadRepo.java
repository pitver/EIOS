package ru.stc23.eios.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stc23.eios.model.FileBase64;
import org.springframework.data.jpa.repository.Query;

import java.io.File;
import java.util.List;

public interface FileUploadRepo extends JpaRepository<FileBase64,Long> {

    List<FileBase64> findAllByFilename (FileBase64 file);

}
