package ru.stc23.eios.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.stc23.eios.model.Review;
import ru.stc23.eios.model.User;
import ru.stc23.eios.model.Work;

import java.util.List;

/**
 * @author Петр Вершинин
 */
public interface ReviewRepo extends JpaRepository<Review,Long> {



    List<Review>findByWork(Work work);
    void deleteById(Long id);



}
