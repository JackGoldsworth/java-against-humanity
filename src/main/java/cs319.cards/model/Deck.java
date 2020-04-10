package cs319.cards.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {

    private LinkedList<Card> deck;

    private int size;

    private boolean isBlack; //temp

    public Deck() {
        deck = new LinkedList<Card>();
        size = 0;
    }

    public Deck(List<Card> l) {
        size = l.size();
        for (int i = 0; i < l.size(); i++) {
            deck.push(l.get(i));
        }
    }

    public int getSize() { return size; }

    public Card draw() { size--; return deck.pop(); }

    public void shuffle() { Collections.shuffle(deck); }

    /**
     * Adds a NEW card to the deck, not returning an old one
     * @param c Card to be added
     */
    public void addCard(Card c) {
        deck.push(c);
        size++;
    }
}
