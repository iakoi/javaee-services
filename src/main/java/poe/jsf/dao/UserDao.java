package poe.jsf.dao;


import poe.jsf.domain.Track;
import poe.jsf.domain.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserDao {

    @PersistenceContext(unitName = "persistence-unit-h2")
    private EntityManager em;

    @EJB
    TrackDao trackDao;

    public Long add(User user) {
        System.out.println("em: " + em);
        em.persist(user);
        return user.getId();
    }

    public List<User> list() {
        return em.createQuery("select e from User e").getResultList();
    }

    public void delete(Long userId) {
        User userToDelete = em.find(User.class, userId);
        em.remove(userToDelete);
    }

    public void update(User user) {
        System.out.println("update user : " + user.getId());
        user = em.merge(user);
    }

    public void deleteEntity(User userToDelete) {
        em.remove(userToDelete);
    }

    public User get(Long userId) {
        return em.find(User.class, userId);

    }

    public void addTrack(Long userId, Long trackId) {
        User user = get(userId);
        Track track = trackDao.get(trackId);
        user.getTracks().add(track);
        em.persist(user);
    }

}
