package poe.jsf.backingbean;

import poe.jsf.dao.UserDao;
import poe.jsf.domain.User;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class ShowUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private UserDao userDao;

    @ManagedProperty("#{param.userid}")
    private Long userId;


    private User user;

    public String show() {
        this.user = userDao.get(userId);
        return "showUser";
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
}
