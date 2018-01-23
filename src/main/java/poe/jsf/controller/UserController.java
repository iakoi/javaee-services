package poe.jsf.controller;

import poe.jsf.dao.UserDao;
import poe.jsf.domain.User;

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

    public UserController() {
        user = new User();
    }

    public void add() {
        System.out.println("adding user " + user.getEmail());
        userDao.add(user);
    }

    public List<User> list() {
        return userDao.list();
    }

    public String delete(Long userId) {
        userDao.delete(userId);
        return "list-users";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
