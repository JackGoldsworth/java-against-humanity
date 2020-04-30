package cs319.cards.model;

import java.util.List;

public class PartyInfo {

    private final String hostname;
    private final List<User> users;
    private final QuestionCard blackCard;
    private final String czar;
    private final List<AnswerCard> playedCards;
    private final User winner;

    public PartyInfo(String hostname, List<User> users, QuestionCard blackCard, String czar, List<AnswerCard> playedCards, User winner) {
        this.hostname = hostname;
        this.users = users;
        this.blackCard = blackCard;
        this.czar = czar;
        this.playedCards = playedCards;
        this.winner = winner;
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

    public List<AnswerCard> getPlayedCards() {
        return playedCards;
    }

    public User getWinner() {
        return winner;
    }
}
