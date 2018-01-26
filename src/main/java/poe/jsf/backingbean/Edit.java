package poe.jsf.backingbean;

import poe.jsf.dao.TrackDao;
import poe.jsf.dao.UserDao;
import poe.jsf.domain.Track;
import poe.jsf.domain.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@RequestScoped
public class Edit implements Serializable {
    private static final long serialVersionUID = 1L;

    private User user;

    private String[] tracksToAdd;

    @ManagedProperty("#{param.userid}")
    private Long userId;

    @EJB
    private UserDao userDao;

    private TrackDao trackDao;

    private List<Track> allTracks;

    public String show() {
        this.user = userDao.get(userId);
        return "edit";
    }

    public Edit() {
        user = new User();
    }

    @PostConstruct
    public void init() {
        allTracks = trackDao.list();
    }

    public String update() {
        System.out.println("this.user id " + this.user.getId());
        userDao.update(this.user);
        return "list";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String[] getTracksToAdd() {
        return tracksToAdd;
    }

    public void setTracksToAdd(String[] tracksToAdd) {
        this.tracksToAdd = tracksToAdd;
    }

    public List<Track> getAllTracks() {
        return allTracks;
    }

    public void setAllTracks(List<Track> allTracks) {
        this.allTracks = allTracks;
    }
}
