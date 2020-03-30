package cs319.cards.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final String username;
    private final List<Card> currentCards = new ArrayList<>();

    public User(String username) {
        this.username = username;
    }

    public void addCard(Card card) {
        currentCards.add(card);
    }

    public void removeCards(Card card) {
        currentCards.remove(card);
    }

    public List<Card> getCurrentCards() {
        return currentCards;
    }

    public String getUsername() {
        return username;
    }
}
