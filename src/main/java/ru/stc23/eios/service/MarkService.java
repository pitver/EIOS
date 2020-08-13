package ru.stc23.eios.service;

import org.springframework.stereotype.Service;
import ru.stc23.eios.model.Mark;
import ru.stc23.eios.repos.MarkRepo;

import java.util.List;

/**
 * MarkService
 *
 * @author Вершинин Пётр
 */
@Service
public class MarkService {

    private final MarkRepo markRepo;

    public MarkService(MarkRepo markRepo) {
        this.markRepo = markRepo;
    }

    public List<Mark> findMarkAll(){return markRepo.findAll();}
    public Mark findMarkById(Long id){return  findMarkById(id);}
    public Mark add(Mark mark){return markRepo.save(mark);}
}
