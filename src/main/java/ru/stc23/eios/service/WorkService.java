package ru.stc23.eios.service;

import org.springframework.stereotype.Service;
import ru.stc23.eios.exception.RecordNotFoundException;
import ru.stc23.eios.model.Mark;
import ru.stc23.eios.model.Review;
import ru.stc23.eios.model.User;
import ru.stc23.eios.model.Work;
import ru.stc23.eios.repos.MarkRepo;
import ru.stc23.eios.repos.ReviewRepo;
import ru.stc23.eios.repos.WorkRepo;

import java.util.List;
import java.util.Optional;

/**
 * @author Петр Вершинин
 */
@Service
public class WorkService {

    private final WorkRepo workRepo;

    private final ReviewRepo reviewRepo;
    private final MarkRepo markRepo;

    public WorkService(WorkRepo workRepo, ReviewRepo reviewRepo, MarkRepo markRepo) {
        this.workRepo = workRepo;
        this.reviewRepo = reviewRepo;
        this.markRepo = markRepo;
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
    public Review findReviewByWorkId(Work work) {
        List<Review> reviewById = reviewRepo.findByComment(work);
        if (!reviewById.isEmpty()) {
            return reviewById.get(0);
        } else {
            return new Review();
        }
    }

    public Mark findMarkByWorkId(Work work){
        List<Mark> markByWorkId = markRepo.findByWork(work);
        if (!markByWorkId.isEmpty()) {
            return markByWorkId.get(0);
        } else {
            return new Mark();
        }
    }
    public void deleteWork(Work work){workRepo.delete(work);}
    public void deleteReview(Review review){reviewRepo.delete(review);}

    public List<Work> workList(){return workRepo.findAll();}
    public List<Work> workListById(User user){return workRepo.findByAuthor(user);}




}
