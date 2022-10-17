package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.User;
import web.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void update(Long id, User userToUpdate) {
        userToUpdate.setId(id);
        userRepository.save(userToUpdate);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
