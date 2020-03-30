package cs319.cards.model;

import java.util.ArrayList;
import java.util.List;

public class Party {

    private final String hostname;
    private final List<User> users = new ArrayList<>();

    public Party(String hostname) {
        this.hostname = hostname;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void removeUserByName(String name) {
        users.forEach(user -> {
            if(user.getUsername().equals(name)) {
                users.remove(user);
            }
        });
    }

    public String getHostname() {
        return hostname;
    }
}
