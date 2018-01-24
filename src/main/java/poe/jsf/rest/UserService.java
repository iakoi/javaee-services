package poe.jsf.rest;

import poe.jsf.dao.TrackDao;
import poe.jsf.dao.UserDao;
import poe.jsf.domain.Track;
import poe.jsf.domain.User;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("user")
public class UserService {

    @EJB
    private UserDao userDao;

    @EJB
    private TrackDao trackDao;

    @GET
    @Produces("application/json")
    @Path("{id}")
    public User show(@PathParam("id") Long userId) {
        User user = userDao.get(userId);
        System.out.println("the user to show " + user.getId());
        return user;
    }

    @POST
    @Path("/{email}/{password}")
    public Response add(@PathParam("email") String email, @PathParam("password") String password, @Context UriInfo uriInfo) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        Long userId = userDao.add(user);
        return Response.created(uriInfo.getBaseUriBuilder().path(UserService.class).path(Long.toString(userId)).build()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addJson(User user, @Context UriInfo uriInfo) {
        Long userId = userDao.add(user);
        return Response.created(uriInfo.getBaseUriBuilder().path(UserService.class).path(Long.toString(userId)).build()).build();
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long userId) {
        userDao.delete(userId);
    }

    @GET
    public List<User> list() {
        return userDao.list();
    }

    @POST
    @Path("playlist/add/{userId}/{trackId}")
    public void addTrack(@PathParam("userId") Long userId, @PathParam("trackId") Long trackId) {

        userDao.addTrack(userId, trackId);

    }
}