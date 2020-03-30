package cs319.cards.model;

/**
 * Handles game state logic and rules
 */
public class Game {

    protected Party party;

    public Game(Party p) { //should also require a parameter for the deck, either a separate class or a list of cards
        party = p;         //depending on implementation, as well as any custom rules(conditions for game end, etc.
    }

}
