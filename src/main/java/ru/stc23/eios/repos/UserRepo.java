package ru.stc23.eios.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.stc23.eios.model.Student;
import ru.stc23.eios.model.User;

/**
 * UserRepo
 *
 * @author Вершинин Пётр
 */
@Repository
public interface UserRepo<T extends User> extends PagingAndSortingRepository<T,Long> {
    T findByUsername(String username);
    @Query(value="select * from usr u LEFT JOIN teacher_specification t " +
            "on u.id=t.teacher_id where usr_type='teacher'",nativeQuery = true)

    Page<T> findAllByTeacher(Pageable pageable);

    @Query(value="select * from usr u  where usr_type='student'",nativeQuery = true)
    Page<T> findAllByStudent(Pageable pageable);

    Page<Student> findByStudentGroup(String name, Pageable pageable);
    Page<Student> findById(Long id, Pageable pageable);

    @Query(value="select * from student_student_group s LEFT JOIN usr u " +
            "on s.student_id=u.id where usr_type='student'",nativeQuery = true)
    Page<T> findStudentGroup(Pageable pageable);



}
