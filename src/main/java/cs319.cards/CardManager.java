package cs319.cards;

import cs319.cards.model.AnswerCard;
import cs319.cards.model.QuestionCard;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class manages all the cards
 * after loading them up in the start.
 */
public class CardManager {

    public static final List<QuestionCard> QUESTION_CARDS = JsonUtils.loadQuestionCardsJson();
    public static final List<AnswerCard> ANSWER_CARDS = JsonUtils.loadAnswerCardsJson();

    private CardManager() {
        // Makes sure the class cannot be instantiated.
    }

    /**
     * Get question card information from the cards id.
     *
     * @param cardId cards unique id.
     * @return card model.
     */
    public static QuestionCard getQuestionCardById(short cardId) {
        if (QUESTION_CARDS != null) {
            return QUESTION_CARDS.stream().filter(card -> card.getCardId() == cardId).findFirst().orElse(null);
        }
        return null;
    }

    /**
     * Get answer card information from the cards id.
     *
     * @param cardId cards unique id.
     * @return card model.
     */
    public static AnswerCard getAnswerCardById(short cardId) {
        if (ANSWER_CARDS != null) {
            return ANSWER_CARDS.stream().filter(card -> card.getCardId() == cardId).findFirst().orElse(null);
        }
        return null;
    }


    /**
     * Converts a list of question card ids to card model classes.
     *
     * @param cardIds list of card ids.
     * @return list of card model classes.
     */
    public static List<QuestionCard> convertIdToQuestionCards(List<Short> cardIds) {
        return cardIds.stream().map(CardManager::getQuestionCardById).collect(Collectors.toList());
    }

    /**
     * Converts a list of answer card ids to card model classes.
     *
     * @param cardIds list of card ids.
     * @return list of card model classes.
     */
    public static List<AnswerCard> convertIdToAnswerCards(List<Short> cardIds) {
        return cardIds.stream().map(CardManager::getAnswerCardById).collect(Collectors.toList());
    }
}
