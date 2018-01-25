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
public class ListUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private UserDao userDao;

    private List<User> users;

    @PostConstruct
    public void init() {
        users = userDao.list();
    }






    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
