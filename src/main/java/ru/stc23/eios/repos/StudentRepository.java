package ru.stc23.eios.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.stc23.eios.model.Student;
import ru.stc23.eios.model.User;

import javax.transaction.Transactional;

/**
 * UserRepo
 *
 * @author Вершинин Пётр
 */

@Transactional
public interface StudentRepository extends UserRepo<Student> {


}


