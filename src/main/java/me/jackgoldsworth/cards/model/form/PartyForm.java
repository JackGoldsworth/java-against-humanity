package me.jackgoldsworth.cards.model.form;

import java.util.List;

public class PartyForm {

    private final String username;
    private final List<Integer> cardPacks;
    private final int maxPlayers;
    private final int scoreToWin;

    public PartyForm(String username, List<Integer> cardPacks, int maxPlayers, int scoreToWin) {
        this.username = username;
        this.cardPacks = cardPacks;
        this.maxPlayers = maxPlayers;
        this.scoreToWin = scoreToWin;
    }

    public String getUsername() {
        return username;
    }

    public List<Integer> getCardPacks() {
        return cardPacks;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getScoreToWin() {
        return scoreToWin;
    }
}
