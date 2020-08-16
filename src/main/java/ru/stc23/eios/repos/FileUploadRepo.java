package ru.stc23.eios.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.stc23.eios.model.FileBase64;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Stream;

public interface FileUploadRepo extends JpaRepository<FileBase64,Long> {

//    List<FileBase64> getAllByUser (FileBase64 file);
    FileBase64 getByFilename (String filename);
    FileBase64 findByFilename (String filename);


   // Page<FileBase64> getAllByUser();







//    @Query(value="select * from files u  where author ='null'")
//    Page<FileBase64> findNullAuthor(Pageable pageable);

}
