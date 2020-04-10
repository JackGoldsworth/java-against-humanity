package cs319.cards.model;

import java.util.List;

public class CardManager {

    private final List<Card> cards;

    public CardManager(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }
}
