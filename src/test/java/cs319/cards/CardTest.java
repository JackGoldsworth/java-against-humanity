package cs319.cards;

import cs319.cards.model.AnswerCard;
import cs319.cards.model.QuestionCard;
import cs319.cards.utils.JsonUtils;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CardTest {

    private List<AnswerCard> answerCardList;
    private List<QuestionCard> questionCardList;

    private List<AnswerCard> dummyAnswerList;
    private List<QuestionCard> dummyQuestionList;

    @BeforeAll
    public void load() {
        answerCardList = JsonUtils.loadAnswerCardsJson("src/test/resources/answer_cards.json");
        questionCardList = JsonUtils.loadQuestionCardsJson("src/test/resources/question_cards.json");
        dummyAnswerList = new ArrayList<>();
        dummyQuestionList = new ArrayList<>();

        dummyAnswerList.add(new AnswerCard(0, "\"Tweeting.\"", 0));
        dummyAnswerList.add(new AnswerCard(1, "(I am doing Kegels right now.)", 0));
        dummyAnswerList.add(new AnswerCard(2, "10,000 Syrian refugees.", 0));

        dummyQuestionList.add(new QuestionCard(0, "50% of all marriages end in ______.", 1, 0));
        dummyQuestionList.add(new QuestionCard(1, "______. Betcha can't have just one!", 1, 0));
        dummyQuestionList.add(new QuestionCard(2, "______. High five, bro.", 1, 0));
    }

    @DisplayName("Test Loading Answers")
    @Test
    public void testAnswerLoad() {
        Assertions.assertTrue(answerCardList.contains(dummyAnswerList.get(0)));
        Assertions.assertTrue(answerCardList.contains(dummyAnswerList.get(1)));
        Assertions.assertTrue(answerCardList.contains(dummyAnswerList.get(2)));
    }

    @DisplayName("Test Loading Questions")
    @Test
    public void testQuestionLoad() {
        Assertions.assertTrue(questionCardList.contains(dummyQuestionList.get(0)));
        Assertions.assertTrue(questionCardList.contains(dummyQuestionList.get(1)));
        Assertions.assertTrue(questionCardList.contains(dummyQuestionList.get(2)));
    }

    @AfterAll
    public void unload() {
        answerCardList = null;
        questionCardList = null;
        dummyQuestionList = null;
        dummyAnswerList = null;
    }
}
