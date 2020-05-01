package me.jackgoldsworth.cards.model.form;

public class PlayCardForm {

    private final String username;
    private final String cardMessage;

    public PlayCardForm(String username, String cardMessage) {
        this.username = username;
        this.cardMessage = cardMessage;
    }

    public String getUsername() {
        return username;
    }

    public String getCardMessage() {
        return cardMessage;
    }
}
