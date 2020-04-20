package cs319.cards.model;

import java.util.List;
import java.util.Objects;

public class QuestionCard implements Card {

    private final int cardId;
    private final String cardMessage;
    private final int blanks;
    private final int cardPack;

    public QuestionCard(int cardId, String cardMessage, int blanks, int cardPack) {
        this.cardId = cardId;
        this.cardMessage = cardMessage;
        this.blanks = blanks;
        this.cardPack = cardPack;
    }

    public int getCardId() {
        return cardId;
    }

    public String getCardMessage() {
        return cardMessage;
    }

    public int getBlanks() {
        return blanks;
    }

    public int getCardPack() {
        return cardPack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionCard questionCard = (QuestionCard) o;
        return cardId == questionCard.cardId &&
                blanks == questionCard.blanks &&
                Objects.equals(cardMessage, questionCard.cardMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, cardMessage, blanks);
    }

    public class QuestionDeck {

        private final List<QuestionCard> cards;

        public QuestionDeck(List<QuestionCard> cards) {
            this.cards = cards;
        }

        public List<QuestionCard> getQuestionCards() {
            return cards;
        }
    }

}