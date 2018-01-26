package poe.jsf.rest;

import poe.jsf.dao.TrackDao;
import poe.jsf.dao.UserDao;
import poe.jsf.domain.User;
import poe.jsf.rest.to.UserTO;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

@Path("user")
public class UserService {

    @EJB
    private UserDao userDao;

    @EJB
    private TrackDao trackDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public UserTO show(@PathParam("id") Long userId) {
        User user = userDao.get(userId);
        UserTO userTo = UserTO.buildFrom(user);
        System.out.println("the user to show " + userTo + " tracks count " + userTo.getTracks().size());
        return userTo;
    }

    @POST
    @Path("/{mail}/{password}")
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

    @PUT
    @Path("{id}/{email}/{password}")
    public void update(@PathParam("email") String email, @PathParam("password") String password, @PathParam("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setPassword(password);
        userDao.update(user);
    }

    @GET
    public List<UserTO> list() {
        List<UserTO> usersTo = new ArrayList<>();
        for (User user : userDao.list()) {
            usersTo.add(UserTO.buildFrom(user));
        }
        return usersTo;

    }

    @POST
    @Path("playlist/add/{userId}/{trackId}")
    public void addTrack(@PathParam("userId") Long userId, @PathParam("trackId") Long trackId) {
        System.out.println("adding track " + trackId + " to user " + userId);
        userDao.addTrack(userId, trackId);

    }

    @DELETE
    @Path("{userId}/{trackId}")
    public void deleteTrackFromUser(@PathParam("userId") Long userId, @PathParam("trackId") Long trackId) {
        userDao.deleteTrackFromUser(userId, trackId);
    }

}