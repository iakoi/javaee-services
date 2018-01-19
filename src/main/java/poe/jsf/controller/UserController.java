package poe.jsf.controller;

import poe.jsf.dao.UserDao;
import poe.jsf.domain.User;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class UserController implements Serializable {
    private static final long serialVersionUID = 1L;

    private User user;

    @EJB
    private UserDao userDao;

    public UserController() {
        user = new User();
    }

    public void add() {
        System.out.println("adding user " + user.getEmail());
        userDao.add(user);
    }

    public String show() {
        System.out.println("user in form ");
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());

        // enregistrer le user en bdd
        // afficher à l'utilisateur qu'on a bien pris
        // en compte son inscription

        return "home";
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
