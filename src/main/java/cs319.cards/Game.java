package cs319.cards;

import cs319.cards.model.Card;
import cs319.cards.model.Deck;
import cs319.cards.model.Party;
import cs319.cards.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles game state logic and rules
 */
public class Game {

    private Party party;

    private Deck deck;

    private Deck blackDeck;

    private Card blackCard;

    private User czar;

    private List<Card> czarSubmissions;

    private Deck waste;

    public Game(Party p, Deck blackDeck, Deck whiteDeck) {
        party = p;
        deck = whiteDeck;
        this.blackDeck = blackDeck;
        czar = p.getUserByIndex(0); //temp
        czarSubmissions = new ArrayList<Card>();
        waste = new Deck();
    }

    //Getters
    public User getCzar() { return czar; }

    public String getCzarName() { return czar.getUsername(); }

    public List<Card> getCzarChoices() { return czarSubmissions; }

    public Party getParty() { return party; }

    public Card getBlackCard() { return blackCard; }

    //Game Actions
    /**
     * Gives each player 10 cards and does other necessary things for the start of the game
     * Must be called once before any other game actions
     */
    public void startGame() {
        deck.shuffle();
        blackDeck.shuffle();

        for (int i = 0; i < party.getPartySize(); i++) {
            for (int j = 0; j < 10; j++) {
                party.getUserByIndex(i).addCard(deck.draw());
            }
        }

        blackCard = blackDeck.draw();
    }

    /**
     * Plays a card for the czar to consider (single blank)
     * @param c Card to play
     */
    public void playCardSingle(Card c, User u) {
        czarSubmissions.add(c);
        u.removeCards(c);
    }

    /**
     * Method used by the czar to select their favorite card played (on a single blank black card)
     * @param c The czar's favorite card played
     */
    public void czarSelectSingle(Card c) {
        // add a point to the user that has this card.
        party.getUsers().stream().filter(user -> user.hasCard(c)).findFirst().ifPresent(User::addPoint);

        for (int i = 0; i < czarSubmissions.size(); i++) { //sends all played cards to the waste pile
            Card card = czarSubmissions.get(i);
            // Removes the card from the user that has this card.
            party.getUsers().stream().filter(user -> user.hasCard(card)).findFirst().ifPresent(user -> user.removeCards(card));
            waste.addCard(czarSubmissions.get(i));
        }

        czarSubmissions = new ArrayList<Card>(); //resets czar choices

        for (int i = 0; i < party.getPartySize(); i++) { //draws each player back up to 10 cards
            if (party.getUserByIndex(i).getCurrentCards().size() < 10) {
                party.getUserByIndex(i).addCard(deck.draw());
            }
        }

        //todo: pick next czar, black card
    }
    


}
