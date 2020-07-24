package ru.stc23.eios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.stc23.eios.exception.RecordNotFoundException;
import ru.stc23.eios.model.User;
import ru.stc23.eios.repos.UserRepo;

import java.util.List;
import java.util.Optional;

/**
 * использууем 3-ех звенную модель, обращения к репозиторию
 * происходет через сервис
 *
 * UserSevise
 *
 * @author Вершинин Пётр
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }
    public User getUserById(Long id) throws RecordNotFoundException
    {
        Optional<User> employee = userRepo.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public User addUser(User user){
        return userRepo.save(user);
    }
    public List<User> findUserAll(){
        return userRepo.findAll();
    }


}
