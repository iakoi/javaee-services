package poe.jsf.rest;

import poe.jsf.dao.UserDao;
import poe.jsf.domain.User;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("rest")
public class HelloRestService {

    @EJB
    private UserDao userDao;

    @GET
    @Produces("text/html")
    @Path("hi")
    public String hi() {

        return "hey " + userDao.list().size();
    }

    @GET
    @Produces("application/json")
    @Path("/show")
    public User show(@QueryParam("id")int id) {
        User user = new User();
        user.setEmail("jhjh@email.com");
        return user;
    }
}
