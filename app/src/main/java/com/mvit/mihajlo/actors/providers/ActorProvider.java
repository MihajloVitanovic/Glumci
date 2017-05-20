package com.mvit.mihajlo.actors.providers;

import com.mvit.mihajlo.actors.models.Actor;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by androiddevelopment on 20.5.17..
 */

public class ActorProvider {

    public static List<String> getActorNames() {

        List<String> names = new ArrayList<>();
        names.add("Brad Pitt");
        names.add("Johnny Depp");
        names.add("Olivia Wilde");
        return names;
    }

    public static List<String> getActorMovies() {

        List<String> names = new ArrayList<>();
        names.add("Movie 1");
        names.add("Movie 3");
        names.add("Movie 2");
        return names;
    }

    public static Actor getActorById(int id) {
        switch (id){
            case 0:
                return new Actor(0, "bradpitt.png", "Brad", "Pitt", "Brad Pitt Summary", 4, new GregorianCalendar(2017, 5, 20).getTime() , "Filmovi bred pita");
            case 1:
                return new Actor(1, "johnnydepp.png", "Johnny", "Depp", "Johnny Depp Summary", 4, new GregorianCalendar(2017, 5, 20).getTime(), "Filmovi dzonija");
            case 2:
                return new Actor(2, "oliviawilde.png", "Olivia", "Wilde", "Olivia Wilde Summary", 4, new Date(2017, 5, 20), "Filmovi olivije");
            default:
            return null;
        }
    }

}
