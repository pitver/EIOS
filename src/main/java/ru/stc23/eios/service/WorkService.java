package ru.stc23.eios.service;

import org.springframework.stereotype.Service;
import ru.stc23.eios.exception.RecordNotFoundException;
import ru.stc23.eios.model.User;
import ru.stc23.eios.model.Work;
import ru.stc23.eios.repos.WorkRepo;

import java.util.List;
import java.util.Optional;

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
    public Work findById(Long id) throws RecordNotFoundException {
        Optional<Work> workById = workRepo.findById(id);
        if (workById.isPresent()) {
            return workById.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
    public void deleteWork(Work work){workRepo.delete(work);}
    public List<Work> workList(){return workRepo.findAll();}
    public List<Work> workListById(User user){return workRepo.findByAuthor(user);}


}
