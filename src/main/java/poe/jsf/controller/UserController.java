package poe.jsf.controller;

import poe.jsf.dao.UserDao;
import poe.jsf.domain.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@RequestScoped
public class UserController implements Serializable {
    private static final long serialVersionUID = 1L;

    private User user;

    @EJB
    private UserDao userDao;

    private List<User> users;

    public UserController() {
        user = new User();
    }

    @PostConstruct
    public void init() {
        users = userDao.list();
    }

    public String add() {
        System.out.println("adding user " + user.getEmail());
        userDao.add(user);
        user = new User();
        return "signup";
    }

    public List<User> list() {
        return users;
    }

    public String delete(Long userId) {
        userDao.delete(userId);
        return "list";
    }

    public String showUpdatePage(Long userId) {
        this.user = userDao.get(userId);
        //context.view.addModel(user);
        return "update";
    }

    public String showPageHome(User user) {
        System.out.println("showPageHome" + this.user.getEmail());
        System.out.println("showPageHome" + user.getEmail());
        return "home";
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

}
