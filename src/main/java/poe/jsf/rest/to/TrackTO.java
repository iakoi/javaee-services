package poe.jsf.rest.to;

import poe.jsf.domain.Track;
import poe.jsf.domain.User;

import java.util.ArrayList;
import java.util.List;

public class TrackTO {
    long id;

    String title;

    String artist;

    List<UserTO> users;


    public static TrackTO buildFrom(Track track) {
        TrackTO trackTO = new TrackTO();
        trackTO.setId(track.getId());
        trackTO.setArtist(track.getArtist());
        trackTO.setTitle(track.getTitle());

        List<UserTO> users = new ArrayList<>();
        for (User user : track.getUsers()) {
            UserTO userTO = UserTO.buildFrom(user);
            userTO.setTracks(null);
            trackTO.getUsers().add(userTO);
        }
        return trackTO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<UserTO> getUsers() {
        if(users == null) {
            users = new ArrayList<>();
        }
        return users;
    }

    public void setUsers(List<UserTO> users) {
        this.users = users;
    }
}
