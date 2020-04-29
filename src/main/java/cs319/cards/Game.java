package cs319.cards;

import cs319.cards.model.AnswerCard;
import cs319.cards.model.Party;
import cs319.cards.model.QuestionCard;
import cs319.cards.model.User;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Handles game state logic and rules
 */
public class Game {

    private Party party;
    private List<Integer> deck;
    private List<Integer> blackDeck;
    private QuestionCard curBlackQuestionCard;
    private User czar;
    private Map<User, Integer> czarSubmissions;
    private List<Integer> waste;
    private List<Integer> blackWaste;
    private int scoreToWin;

    public Game(Party p, List<Integer> blackDeck, List<Integer> whiteDeck, int scoreToWin) {
        party = p;
        deck = whiteDeck;
        this.blackDeck = blackDeck;
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
        Collections.shuffle(deck);
        Collections.shuffle(blackDeck);

        for (int i = 0; i < party.getPartySize(); i++) {
            for (int j = 0; j < 10; j++) {
                int chosenCard = ThreadLocalRandom.current().nextInt(deck.size());
                party.getUserByIndex(i).addCard(deck.get(chosenCard));
                waste.add(chosenCard);
            }
        }

        int chosenCard = ThreadLocalRandom.current().nextInt(blackDeck.size());
        curBlackQuestionCard = CardManager.getQuestionCardById(blackDeck.get(chosenCard));
        blackWaste.add(chosenCard);
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
        party.getUsers().stream().filter(u -> u.hasCard(c)).findFirst().ifPresent(User::addPoint);

        for (Integer card : czarSubmissions.values()) { //sends all played cards to the waste pile
            AnswerCard answerCard = CardManager.getAnswerCardById(card);
            // Removes the card from the user that has this card.
            party.getUsers().stream().filter(u -> u.hasCard(answerCard)).findFirst().ifPresent(u -> u.removeCards(answerCard));
            waste.add(card);
        }

        czarSubmissions.clear(); //resets czar choices


        for (int i = 0; i < party.getPartySize(); i++) { //draws each player back up to 10 cards
            if (party.getUserByIndex(i).getCurrentCards().size() < 10) {
                party.getUserByIndex(i).addCard(deck.get(ThreadLocalRandom.current().nextInt(deck.size())));
            }
        }

        blackWaste.add(curBlackQuestionCard.getCardId());
        int chosenCard = ThreadLocalRandom.current().nextInt(blackDeck.size());
        curBlackQuestionCard = CardManager.getQuestionCardById(blackDeck.get(chosenCard));
        blackWaste.add(chosenCard);

        shiftCzar();
    }

    /**
     * Checks if any player has won
     *
     * @return Winning User, or null if no winner found
     */
    public User checkForWinner() {
        for (int i = 0; i < party.getPartySize(); i++) {
            if (party.getUserByIndex(i).getPoints() >= scoreToWin) {
                return party.getUserByIndex(i);
            }
        }
        return null;
    }

    //assumes party is ordered in turn order, subject to change
    public void shiftCzar() {
        if (party.getUsers().indexOf(czar) >= (party.getPartySize() - 1)) {
            czar = party.getUsers().get(0);
        } else {
            czar = party.getUsers().get(party.getUsers().indexOf(czar) + 1);
        }
    }
}
