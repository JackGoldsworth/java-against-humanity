package cs319.cards.model;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class Party {

    private final String hostname;
    private final List<User> users = new ArrayList<>();
    private final String id;

    public Party(String hostname) {
        this.hostname = hostname;
        this.id = RandomStringUtils.randomAlphanumeric(6);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void removeUserByName(String name) {
        users.forEach(user -> {
            if (user.getUsername().equals(name)) {
                users.remove(user);
            }
        });
    }

    public String getHostname() {
        return hostname;
    }

    public String getPartyId() {
        return id;
    }

    public User getUserByName(String name) {
        for(int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(name)) {
                return users.get(i);
            }
        }
        return null;
    }

    public User getUserByIndex(int index) { return users.get(index); }

    public int getIndexByUsername(String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int getPartySize() {
        return users.size();
    }

    public List<User> getUsers() {
        return users;
    }

    public boolean containsUser(String username) {
        return users.stream().anyMatch(user -> user.getUsername().equals(username));
    }
}
