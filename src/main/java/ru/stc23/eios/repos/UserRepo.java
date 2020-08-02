package ru.stc23.eios.repos;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.stc23.eios.model.User;

/**
 * UserRepo
 *
 * @author Вершинин Пётр
 */
public interface UserRepo extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
