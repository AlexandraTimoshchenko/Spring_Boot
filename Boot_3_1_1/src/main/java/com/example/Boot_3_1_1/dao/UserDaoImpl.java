package com.example.Boot_3_1_1.dao;

import com.example.Boot_3_1_1.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> index() {
        return entityManager.createQuery("SELECT u from User u", User.class).getResultList();
    }

    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(int id, User user) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(user.getName());
        userToBeUpdated.setGender(user.getGender());
        entityManager.merge(userToBeUpdated);
    }

    public void delete(int id) {
        entityManager.remove(show(id));
    }
}
