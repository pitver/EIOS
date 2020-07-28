package ru.stc23.eios.repos;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.stc23.eios.model.User;

/**
 * UserRepo
 *
 * @author Вершинин Пётр
 */
@NoRepositoryBean
 interface UserRepo<T extends User> extends PagingAndSortingRepository<T,Long> {
    T findByUsername(String username);
}
