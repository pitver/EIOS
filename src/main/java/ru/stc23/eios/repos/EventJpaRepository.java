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

   @Query("select b from Event b where b.startDateTime >= ?1 and b.endDateTime <= ?2 and b.author= ?3" )
  public List<Event> findByDateBetween(LocalDateTime start, LocalDateTime end, Student user);

    List<Event> findByAuthor(User user);


}
