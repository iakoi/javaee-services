package poe.jsf.dao;


import poe.jsf.domain.Track;
import poe.jsf.domain.Track;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class TrackDao {

    @PersistenceContext(unitName = "persistence-unit-h2")
    private EntityManager em;

    public Long add(Track track) {
        System.out.println("em: " + em);
        em.persist(track);
        return track.getId();
    }


    public List<Track> list() {
        return em.createQuery("select e from Track e").getResultList();
    }

    public void delete(Long trackId) {
        Track trackToDelete = em.find(Track.class, trackId);
        em.remove(trackToDelete);
    }

    public void update(Track track) {
        System.out.println("update track : " + track.getId());
        em.merge(track);
    }

    public void deleteEntity(Track trackToDelete) {
        em.remove(trackToDelete);
    }

    public Track get(Long trackId) {
        return em.find(Track.class, trackId);

    }
}
