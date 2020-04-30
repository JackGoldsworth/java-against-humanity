package cs319.cards;

import cs319.cards.model.AnswerCard;
import cs319.cards.model.Party;
import cs319.cards.model.QuestionCard;
import cs319.cards.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Handles game state logic and rules
 */
public class Game {

    private Party party;
    private List<Integer> packs;
    private QuestionCard curBlackQuestionCard;
    private User czar;
    private Map<User, Integer> czarSubmissions;
    private List<Integer> waste;
    private List<Integer> blackWaste;
    private int scoreToWin;
    private User winner;

    public Game(Party p, List<Integer> cardPacks, int scoreToWin) {
        party = p;
        packs = cardPacks;
        this.scoreToWin = scoreToWin;
        czar = p.getUserByIndex(0); //temp
        czarSubmissions = new HashMap<>();
        waste = new ArrayList<>();
        blackWaste = new ArrayList<>();
    }

    //Getters
    public User getCzar() {
        return czar;
    }

    public String getCzarName() {
        return czar.getUsername();
    }

    public Map<User, Integer> getCzarChoices() {
        return czarSubmissions;
    }

    public Party getParty() {
        return party;
    }

    public QuestionCard getBlackCard() {
        return curBlackQuestionCard;
    }

    //Game Actions

    /**
     * Gives each player 10 cards and does other necessary things for the start of the game
     * Must be called once before any other game actions
     */
    public void startGame() {
        for (int i = 0; i < party.getPartySize(); i++) {
            for (int j = 0; j < 10; j++) {
                int chosenCard = CardManager.getAnswerCardAtRandom(waste, packs);
                party.getUserByIndex(i).addCard(chosenCard);
                waste.add(chosenCard);
            }
        }

        int chosenCard = CardManager.getQuestionCardAtRandom(blackWaste, packs);
        curBlackQuestionCard = CardManager.getQuestionCardById(chosenCard);
        blackWaste.add(chosenCard);
    }

    public void giveCards(User user) {
        for (int j = 0; j < 10; j++) {
            int chosenCard = CardManager.getAnswerCardAtRandom(waste, packs);
            user.addCard(chosenCard);
            waste.add(chosenCard);
        }
    }

    /**
     * Plays a card for the czar to consider (single blank)
     *
     * @param c Card to play
     */
    public void playCardSingle(AnswerCard c, User u) {
        if (!czarSubmissions.containsKey(u)) {
            czarSubmissions.put(u, c.getCardId());
            u.removeCards(c);
        }
    }

    /**
     * Method used by the czar to select their favorite card played (on a single blank black card)
     *
     * @param c The czar's favorite card played
     */
    public void czarSelectSingle(AnswerCard c) {

        // add a point to the user that has this card.
        czarSubmissions.forEach((key, value) -> {
            if (value == c.getCardId()) {
                key.addPoint();
                // If a player has won, set the winner.
                if (key.getPoints() >= scoreToWin) {
                    winner = key;
                }
            }
        });

        for (Integer card : czarSubmissions.values()) { //sends all played cards to the waste pile
            AnswerCard answerCard = CardManager.getAnswerCardById(card);
            // Removes the card from the user that has this card.
            party.getUsers().stream().filter(u -> u.hasCard(answerCard)).findFirst().ifPresent(u -> u.removeCards(answerCard));
            //waste.add(card);
        }

        czarSubmissions.clear(); //resets czar choices


        for (int i = 0; i < party.getPartySize(); i++) { //draws each player back up to 10 cards
            if (party.getUserByIndex(i).getCurrentCards().size() < 10) {
                int chosenCard = CardManager.getAnswerCardAtRandom(waste, packs);
                party.getUserByIndex(i).addCard(chosenCard);
                waste.add(chosenCard);
            }
        }

        int chosenCard = CardManager.getQuestionCardAtRandom(blackWaste, packs);
        curBlackQuestionCard = CardManager.getQuestionCardById(chosenCard);
        blackWaste.add(chosenCard);

        shiftCzar();

    }

    //assumes party is ordered in turn order, subject to change
    public void shiftCzar() {
        if (party.getUsers().indexOf(czar) >= (party.getPartySize() - 1)) {
            czar = party.getUsers().get(0);
        } else {
            czar = party.getUsers().get(party.getUsers().indexOf(czar) + 1);
        }
    }

    public User getWinner() {
        return winner;
    }
}
