package ru.stc23.eios.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.NoRepositoryBean;
import ru.stc23.eios.model.Student;
import ru.stc23.eios.model.Teacher;
import ru.stc23.eios.model.User;

import javax.transaction.Transactional;

/**
 * UserRepo
 *
 * @author Вершинин Пётр
 */

@Transactional
public interface UserRepository extends UserRepo<User> {

}


