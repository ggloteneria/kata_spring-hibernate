package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {


    void save(User user);

    List<User> findAll();

    User findById(Long id);

    void update(User userToUpdate);

    void deleteById(Long id);

}
