package cs319.cards.model;

import java.util.List;
import java.util.Objects;

public class Card {

    private final short cardId;
    private final String cardMessage;
    private final short blanks;

    public Card(short cardId, String cardMessage, short blanks) {
        this.cardId = cardId;
        this.cardMessage = cardMessage;
        this.blanks = blanks;
    }

    public short getCardId() {
        return cardId;
    }

    public String getCardMessage() {
        return cardMessage;
    }

    public short getBlanks() { return blanks; } //if 0 blanks = white card

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardId == card.cardId &&
                blanks == card.blanks &&
                Objects.equals(cardMessage, card.cardMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, cardMessage, blanks);
    }
}