package cs319.cards;

import cs319.cards.model.Card;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class manages all the cards
 * after loading them up in the start.
 */
public class CardManager {

    public static final List<Card> cards = JsonUtils.loadCardsJson();

    private CardManager() {
        // Makes sure the class cannot be instantiated.
    }

    /**
     * Get card information from the cards id.
     *
     * @param cardId cards unique id.
     * @return card model.
     */
    public static Card getCardById(short cardId) {
        if (cards != null) {
            return cards.stream().filter(card -> card.getCardId() == cardId).findFirst().orElse(null);
        }
        return null;
    }

    /**
     * Converts a list of card ids to card model classes.
     *
     * @param cardIds list of card ids.
     * @return list of card model classes.
     */
    public static List<Card> convertIdToCards(List<Short> cardIds) {
        return cardIds.stream().map(CardManager::getCardById).collect(Collectors.toList());
    }
}
