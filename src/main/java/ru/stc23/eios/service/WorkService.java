package ru.stc23.eios.service;

import org.springframework.stereotype.Service;
import ru.stc23.eios.model.User;
import ru.stc23.eios.model.Work;
import ru.stc23.eios.repos.WorkRepo;

import java.util.Collections;
import java.util.List;

/**
 * @author Петр Вершинин
 */
@Service
public class WorkService {

    private final WorkRepo workRepo;
    public WorkService(WorkRepo workRepo) {
        this.workRepo = workRepo;
    }

    public Work addWork(Work work){return workRepo.save(work);}
    public void deleteWork(Work work){workRepo.delete(work);}
    public List<Work> workList(){return workRepo.findAll();}
    public List<Work> workListById(User user){return workRepo.findByAuthor(user);}


}
