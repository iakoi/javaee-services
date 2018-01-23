package poe.jsf.rest;

import poe.jsf.dao.UserDao;
import poe.jsf.domain.User;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("user")
public class UserService {

    @EJB
    private UserDao userDao;

    @GET
    @Produces("application/json")
    @Path("show")
    public User show(@QueryParam("id") Long userId) {
        User user = userDao.get(userId);
        System.out.println("the user to show " + user.getId());
        return user;
    }

    @POST
    @Path("/")
    public void add(@QueryParam("email") String email, @QueryParam("password") String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userDao.add(user);
    }

    @POST
    @Path("/addJson")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addJson(User user) {
        userDao.add(user);
    }
}
