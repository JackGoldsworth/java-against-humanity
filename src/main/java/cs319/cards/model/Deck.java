package cs319.cards.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//whole class might be obsolete now with the card manager
public class Deck<T extends Card> {

    private LinkedList<T> deck;

    private int size;

    public Deck() {
        deck = new LinkedList<T>();
        size = 0;
    }

    public Deck(List<T> l) {
        size = l.size();
        for (int i = 0; i < l.size(); i++) {
            deck.push(l.get(i));
        }
    }

    public int getSize() { return size; }

    public boolean isEmpty() { return (size < 1); }

    public T draw() {
        size--;
        return deck.pop();
    }


    public void shuffle() { Collections.shuffle(deck); }

    /**
     * Adds a NEW card to the deck, not returning an old one
     *
     * @param c Card to be added
     */
    public void addCard(T c) {
        deck.push(c);
        size++;
    }
}
