package cs319.cards.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final String username;
    private final List<Card> currentCards = new ArrayList<>();
    private int points;

    public User(String username) {
        this.username = username;
        points = 0;
    }

    public void addCard(Card card) {
        card.setHolder(this);
        currentCards.add(card);
    }

    public void removeCards(Card card) {
        card.removeHolder();
        currentCards.remove(card);
    }

    public List<Card> getCurrentCards() {
        return currentCards;
    }

    public String getUsername() {
        return username;
    }

    public int getPoints() { return points; }

    public void addPoint() { points++; }

    public void resetPoints() { points = 0; }
}
