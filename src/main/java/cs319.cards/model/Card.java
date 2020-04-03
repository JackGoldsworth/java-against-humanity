package cs319.cards.model;

public class Card {

    private final short cardId;
    private final String cardMessage;
    private boolean held;
    private User holder;

    public Card(short cardId, String cardMessage) {
        this.cardId = cardId;
        this.cardMessage = cardMessage;
        held = false;
        holder = null;
    }

    public short getCardId() {
        return cardId;
    }

    public String getCardMessage() {
        return cardMessage;
    }

    public boolean isHeld() { return held; }

    public User getHolder() { return holder; }

    public void setHolder(User u) { holder = u; held = true; }

    public void removeHolder() { holder = null; held = false; }
}
