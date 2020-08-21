package ru.stc23.eios.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.stc23.eios.exception.RecordNotFoundException;
import ru.stc23.eios.model.Student;
import ru.stc23.eios.model.Teacher;
import ru.stc23.eios.model.User;
import ru.stc23.eios.repos.UserRepo;

import java.util.Optional;

/**
 * использууем 3-ех звенную модель, обращения к репозиторию
 * происходет через сервис
 * <p>
 * UserSevise
 *
 * @author Вершинин Пётр
 */
@Service
public class UserService implements UserDetailsService {

    private final UserRepo<User> userRepository;
    private final UserRepo<Student> studentRepository;
    private final UserRepo<Teacher> teacherRepository;


    public UserService(UserRepo<User> userRepository, UserRepo<Student> studentRepository, UserRepo<Teacher> teacherRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public User getUserById(Long id) throws RecordNotFoundException {
        Optional<User> employee = userRepository.findById(id);

        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public User addUser(User user) {
        return (User) userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public Page<User> findUserAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public Page<Student> findStudentAll(Pageable pageable) {
        return studentRepository.findAllByStudent(pageable);
    }

    public Page<Teacher> findTeacherAll(Pageable pageable) {
        return teacherRepository.findAllByTeacher(pageable);
    }

    public Page<Student> findStudentByFilter(String name,Pageable pageable){
        return studentRepository.findByStudentGroup(name,pageable);
    }
    public Page<Student> findStudentGroup(Pageable pageable){
        return studentRepository.findStudentGroup(pageable);
    }
    public Page<Student> findByID(Long id,Pageable pageable){
        return studentRepository.findById(id,pageable);
    }

}
