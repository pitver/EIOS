package ru.stc23.eios.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stc23.eios.model.Mark;
import ru.stc23.eios.model.Work;

import java.util.List;

/**
 * MarkRepo
 *
 * @author Вершинин Пётр
 */
public interface MarkRepo extends JpaRepository<Mark,Long> {
List<Mark> findByWork(Work work);

}
