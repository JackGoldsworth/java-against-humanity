package cs319.cards.model;

import java.util.List;

public class PartyInfo {

    private final String hostname;
    private final List<User> users;
    private final QuestionCard blackCard;
    private final String czar;

    public PartyInfo(String hostname, List<User> users, QuestionCard blackCard, String czar) {
        this.hostname = hostname;
        this.users = users;
        this.blackCard = blackCard;
        this.czar = czar;
    }

    public String getHostname() {
        return hostname;
    }

    public List<User> getUsers() {
        return users;
    }

    public QuestionCard getBlackCard() {
        return blackCard;
    }

    public String getCzar() {
        return czar;
    }
}
