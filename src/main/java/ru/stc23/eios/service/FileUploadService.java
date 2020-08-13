package ru.stc23.eios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.stc23.eios.exception.FileStorageException;
import ru.stc23.eios.model.FileBase64;
import ru.stc23.eios.repos.FileUploadRepo;

import java.util.Base64;
import java.util.List;

@Service
public class FileUploadService {

    @Autowired
    private final FileUploadRepo fileUploadRepo;

    public FileBase64 storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if (fileName.contains("..")) {
                throw new Exception("Invalid filename");
            }

            Base64.Encoder fileEncoder = Base64.getEncoder();

            FileBase64 fileBase64 = new FileBase64(fileName, file.getContentType(), fileEncoder.encodeToString(file.getBytes()));

            return fileUploadRepo.save(fileBase64);

        } catch (Exception e) {
            throw new FileStorageException("Ошибка загрузки файла");
        }
    }

    public FileBase64 getFile(String fileName) {
        return fileUploadRepo.getByFilename(fileName);
    }

    public List<FileBase64> getAllFiles() {
        return fileUploadRepo.findAll();
    }


    public FileUploadService(FileUploadRepo fileUploadRepo) {
        this.fileUploadRepo = fileUploadRepo;
    }


}


//jdbcTemplate.execute("INSERT INTO File (name, type, data) VALUES (?, ?, ?)",
//        new AbstractLobCreatingPreparedStatementCallback(lobHandler){
//        @Override
//        protected void setValues(PreparedStatement ps,
//                LobCreator lobCreator) throws SQLException,
//                DataAccessException {
//            ps.setString(1, dFile.getName());
//            ps.setString(2, dFile.getType());
//            Blob blob = dFile.getData();
//            int length = (int)blob.length();
//            byte[] b = dFile.getData(); //blob.getBytes(1, length);
//            int length = b.length;
//            InputStream is=new ByteArrayInputStream(b);
//            ps.setBinaryStream(3,  is, length);
//        }
//
//    });

