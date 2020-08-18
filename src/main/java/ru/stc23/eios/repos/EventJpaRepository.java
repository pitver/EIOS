package ru.stc23.eios.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.stc23.eios.model.Event;
import ru.stc23.eios.model.Student;
import ru.stc23.eios.model.User;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface  EventJpaRepository extends JpaRepository<Event, Long> {
    List<Event> findAll();
    Event save(Event event);
    void delete(Event event);

   @Query(value="select b from Event b where b.startDateTime >= ?1 and b.endDateTime <= ?2 and b.author= ?3" )
  public List<Event> findByDateBetween(LocalDateTime start, LocalDateTime end, Student user);

    List<Event> findByAuthor(User user);

    @Query(value = "select ev.* from event ev, student_student_group s" +
            " where ev.student_group=s.student_group and s.student_id= ?1",nativeQuery = true)
    public List<Event> findEventByStudentGroup(Long userId);

    @Query(value = "select ev.* from event ev " +
            " where ev.user_id= ?1",nativeQuery = true)
    public List<Event> findEventByTeacher(User user);

}
