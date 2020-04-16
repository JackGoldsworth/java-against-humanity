package cs319.cards.model;

import java.util.List;
import java.util.Objects;

public class QuestionCard implements Card {

    private final short cardId;
    private final String cardMessage;
    private final short blanks;

    public QuestionCard(short cardId, String cardMessage, short blanks) {
        this.cardId = cardId;
        this.cardMessage = cardMessage;
        this.blanks = blanks;
    }

    public short getCardId() {
        return cardId;
    }

    public String getCardMessage() {
        return cardMessage;
    }

    public short getBlanks() { return blanks; } //if 0 blanks = white card

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