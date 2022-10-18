package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(User user) {
        em.persist(user);
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public User findById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public void update(User userToUpdate) {
        em.merge(userToUpdate);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        em.remove(em.find(User.class, id));
    }

}
