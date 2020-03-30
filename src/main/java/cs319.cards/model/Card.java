package cs319.cards.model;

public class Card {

    private final short cardId;
    private final String cardMessage;

    public Card(short cardId, String cardMessage) {
        this.cardId = cardId;
        this.cardMessage = cardMessage;
    }

    public short getCardId() {
        return cardId;
    }

    public String getCardMessage() {
        return cardMessage;
    }
}
