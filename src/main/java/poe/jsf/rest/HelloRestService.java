package poe.jsf.rest;

import poe.jsf.domain.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("rest")
public class HelloRestService {

    @GET
    @Produces("text/html")
    @Path("hi")
    public String hi() {
        return "hey ";
    }

    @GET
    @Produces("application/json")
    @Path("/show")
    public User show(@QueryParam("id") int id) {
        User user = new User();
        user.setEmail("jhjh@email.com/" + id);
        return user;
    }
}
