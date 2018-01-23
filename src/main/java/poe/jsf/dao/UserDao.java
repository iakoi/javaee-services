package poe.jsf.dao;


import poe.jsf.domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserDao {

    @PersistenceContext(unitName = "persistence-unit-h2")
    private EntityManager em;

    public void add(User user) {
        System.out.println("em: " + em);
        em.persist(user);
    }

    public List<User> list() {
        return em.createQuery("select e from User e").getResultList();
    }

    public void delete(Long userId) {
        User userToDelete = em.find(User.class, userId);
        em.remove(userToDelete);
    }

    public void deleteEntity(User userToDelete) {
        em.remove(userToDelete);
    }


}
