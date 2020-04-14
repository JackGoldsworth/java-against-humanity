package cs319.cards.model;

import java.util.List;

public class CardDeck {

    private final List<Card> cards;

    public CardDeck(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }
}
