package ru.stc23.eios.service;

import org.springframework.beans.factory.annotation.Autowired;
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
import ru.stc23.eios.repos.StudentRepository;
import ru.stc23.eios.repos.TeacherRepository;
import ru.stc23.eios.repos.UserRepository;

import java.util.List;
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


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;

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
        return studentRepository.findAll(pageable);
    }

    public Page<Teacher> findTeacherAll(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }


}
