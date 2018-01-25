package poe.jsf.rest.to;

import poe.jsf.domain.Track;
import poe.jsf.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserTO {

    long id;

    String email;

    String password;

    List<TrackTO> tracks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TrackTO> getTracks() {
        return tracks;
    }

    public void setTracks(List<TrackTO> tracks) {
        this.tracks = tracks;
    }

    public static UserTO buildFrom(User user) {
        UserTO userTo = new UserTO();
        userTo.setEmail(user.getEmail());
        userTo.setPassword(user.getPassword());
        userTo.setId(user.getId());
        List<TrackTO> tracks = new ArrayList<>();
        for (Track track : user.getTracks()) {
            TrackTO trackTo = new TrackTO();
            trackTo.setId(track.getId());
            trackTo.setTitle(track.getTitle());
            trackTo.setArtist(track.getArtist());
            tracks.add(trackTo);
        }
        userTo.setTracks(tracks);
        return userTo;
    }

}
