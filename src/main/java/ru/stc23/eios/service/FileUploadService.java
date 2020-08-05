package ru.stc23.eios.service;

import org.springframework.stereotype.Service;
import ru.stc23.eios.model.FileBase64;
import ru.stc23.eios.model.User;
import ru.stc23.eios.repos.FileUploadRepo;

@Service
public class FileUploadService {

    private final FileUploadRepo fileUploadRepo;

    public FileUploadService(FileUploadRepo fileUploadRepo) {
        this.fileUploadRepo = fileUploadRepo;
    }
    public FileBase64 addFile(FileBase64 fileBase64) {
        return (FileBase64) FileBase64.save(user);
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
}
