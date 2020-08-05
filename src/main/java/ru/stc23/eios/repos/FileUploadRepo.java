package ru.stc23.eios.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stc23.eios.model.Work;

public interface FileUploadRepo extends JpaRepository<Work,String> {

}
