package ru.stc23.eios.repos;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.stc23.eios.model.Review;
import ru.stc23.eios.model.Student;
import ru.stc23.eios.model.User;
import ru.stc23.eios.model.Work;

import java.util.List;

/**
 * @author Петр Вершинин
 */
public interface WorkRepo extends JpaRepository<Work,Long> {

    List<Work> findByAuthor(User user);


}
