package poe.jsf.backingbean;

import poe.jsf.dao.UserDao;
import poe.jsf.domain.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class SignUp implements Serializable {
    private static final long serialVersionUID = 1L;

    private User user;

    @EJB
    private UserDao userDao;

    public SignUp() {
    }

    @PostConstruct
    public void init() {
        user = new User();
    }

    public String add() {
        System.out.println("adding user " + user.getEmail());
        userDao.add(user);
        return "signup";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
