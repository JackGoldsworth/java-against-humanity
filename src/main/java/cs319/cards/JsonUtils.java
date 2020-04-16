package cs319.cards;

import com.google.gson.Gson;
import cs319.cards.model.AnswerCard;
import cs319.cards.model.QuestionCard;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Basic JSON based utility methods.
 *
 * @author Jack Goldsworth
 */
public class JsonUtils {

    private JsonUtils() {
    }

    /**
     * This method loads the question cards json file into
     * memory to be used throughout the duration of the program.
     * This reduces the disk I/O.
     * @return list of cards.
     */
    public static List<QuestionCard> loadQuestionCardsJson() {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        URL file = loader.getResource("question_cards.json");
        Gson gson = new Gson();
        if (file != null) {
            try {
                Reader reader = Files.newBufferedReader(Paths.get(file.toURI()));
                List<QuestionCard> questionCards = gson.fromJson(reader, QuestionCard.QuestionDeck.class).getQuestionCards();
                questionCards.forEach(card -> System.out.println(card.getCardMessage()));
                return questionCards;
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * This method loads the answer cards json file into
     * memory to be used throughout the duration of the program.
     * This reduces the disk I/O.
     * @return list of cards.
     */
    public static List<AnswerCard> loadAnswerCardsJson() {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        URL file = loader.getResource("answer_cards.json");
        Gson gson = new Gson();
        if (file != null) {
            try {
                Reader reader = Files.newBufferedReader(Paths.get(file.toURI()));
                List<AnswerCard> questionCards = gson.fromJson(reader, AnswerCard.AnswerDeck.class).getAnswerCards();
                questionCards.forEach(card -> System.out.println(card.getCardMessage()));
                return questionCards;
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
