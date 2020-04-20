package cs319.cards;

import cs319.cards.model.AnswerCard;
import cs319.cards.model.QuestionCard;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * This class manages all the cards
 * after loading them up in the start.
 */
public class CardManager {

    public static final List<QuestionCard> QUESTION_CARDS = JsonUtils.loadQuestionCardsJson(null);
    public static final List<AnswerCard> ANSWER_CARDS = JsonUtils.loadAnswerCardsJson(null);

    private CardManager() {
        // Makes sure the class cannot be instantiated.
    }

    /**
     * Get question card information from the cards id.
     *
     * @param cardId cards unique id.
     * @return card model.
     */
    public static QuestionCard getQuestionCardById(int cardId) {
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
    public static AnswerCard getAnswerCardById(int cardId) {
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
    public static List<QuestionCard> convertIdToQuestionCards(List<Integer> cardIds) {
        return cardIds.stream().map(CardManager::getQuestionCardById).collect(Collectors.toList());
    }

    /**
     * Converts a list of answer card ids to card model classes.
     *
     * @param cardIds list of card ids.
     * @return list of card model classes.
     */
    public static List<AnswerCard> convertIdToAnswerCards(List<Integer> cardIds) {
        return cardIds.stream().map(CardManager::getAnswerCardById).collect(Collectors.toList());
    }

    /**
     * Chooses a card at random based on what cards the player
     * has and what card packs are allowed on the server.
     *
     * @param playersCurrentCards current cards of players.
     * @param cardPacks           card packs allowed.
     * @return an answer card.
     */
    public static int getAnswerCardAtRandom(List<Integer> playersCurrentCards, List<Integer> cardPacks) {
        List<Integer> answers = ANSWER_CARDS.stream()
                .filter(card -> !playersCurrentCards.contains(card.getCardId()) && cardPacks.contains(card.getCardPack()))
                .map(AnswerCard::getCardId)
                .collect(Collectors.toList());
        return answers.get(ThreadLocalRandom.current().nextInt(answers.size()));
    }

    /**
     * Chooses a card at random based on what cards have
     * been used and what card packs are allowed.
     *
     * @param cardsAlreadyUsed question cards already used.
     * @param cardPacks        card packs allowed.
     * @return a question card.
     */
    public static int getQuestionCardAtRandom(List<Integer> cardsAlreadyUsed, List<Integer> cardPacks) {
        List<Integer> answers = QUESTION_CARDS.stream()
                .filter(card -> !cardsAlreadyUsed.contains(card.getCardId()) && cardPacks.contains(card.getCardPack()))
                .map(QuestionCard::getCardId)
                .collect(Collectors.toList());
        return answers.get(ThreadLocalRandom.current().nextInt(answers.size()));
    }

    /**
     * Returns a list of all question card ids in the specified pack
     *
     * @param packId id of the pack to return
     * @return a list of card ids
     */
    public static List<Integer> getQuestionCardPack(int packId) {
        if (QUESTION_CARDS != null) {
            return QUESTION_CARDS.stream()
                    .filter(card -> card.getCardPack() == packId)
                    .map(QuestionCard::getCardId)
                    .collect(Collectors.toList());
        }
        return null;
    }

    /**
     * Returns a list of all answer card ids in the specified pack
     *
     * @param packId id of the pack to return
     * @return a list of card ids
     */
    public static List<Integer> getAnswerCardPack(int packId) {
        if (ANSWER_CARDS != null) {
            return ANSWER_CARDS.stream()
                    .filter(card -> card.getCardPack() == packId)
                    .map(AnswerCard::getCardId)
                    .collect(Collectors.toList());
        }
        return null;
    }

    /**
     * Returns a list of question card ids from allowed packs
     *
     * @param cardPacks card packs allowed
     * @return a List of card ids
     */
    public static List<Integer> getQuestionCardPacks(List<Integer> cardPacks) {
        if (QUESTION_CARDS != null) {
            return QUESTION_CARDS.stream()
                    .filter(card -> cardPacks.contains(card.getCardPack()))
                    .map(QuestionCard::getCardId)
                    .collect(Collectors.toList());
        }
        return null;
    }

    /**
     * Returns a list of answer card ids from allowed packs
     *
     * @param cardPacks card packs allowed
     * @return a List of card ids
     */
    public static List<Integer> getAnswerCardPacks(List<Integer> cardPacks) {
        if (ANSWER_CARDS != null) {
            return ANSWER_CARDS.stream()
                    .filter(card -> cardPacks.contains(card.getCardPack()))
                    .map(AnswerCard::getCardId)
                    .collect(Collectors.toList());
        }
        return null;
    }
}
