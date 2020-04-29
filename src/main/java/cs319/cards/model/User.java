package cs319.cards.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final String username;
    private final List<Integer> currentCards = new ArrayList<>();
    private int points;

    public User(String username) {
        this.username = username;
        points = 0;
        addCard(0);
        addCard(1);
    }

    public void addCard(AnswerCard answerCard) {
        currentCards.add(answerCard.getCardId());
    }

    public void removeCards(AnswerCard answerCard) {
        currentCards.remove(Integer.valueOf(answerCard.getCardId()));
    }

    public void addCard(int cardId) {
        currentCards.add(cardId);
    }

    public void removeCards(short cardId) {
        currentCards.remove(Integer.valueOf(cardId));
    }

    public List<Integer> getCurrentCards() {
        return currentCards;
    }

    public String getUsername() {
        return username;
    }

    public int getPoints() {
        return points;
    }

    public void addPoint() {
        points++;
    }

    public void resetPoints() {
        points = 0;
    }

    public boolean hasCard(AnswerCard answerCard) {
        return currentCards.contains(answerCard.getCardId());
    }

    public boolean hasCard(int cardId) {
        return currentCards.contains(cardId);
    }
}
