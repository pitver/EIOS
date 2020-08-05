package ru.stc23.eios.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.stc23.eios.model.Event;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface  EventJpaRepository extends JpaRepository<Event, Long> {

   @Query("select b from Event b where b.startDateTime >= ?1 and b.endDateTime <= ?2")
  public List<Event> findByDateBetween(LocalDateTime start, LocalDateTime end);



}
