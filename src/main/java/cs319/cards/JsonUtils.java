package cs319.cards;

import com.google.gson.Gson;
import cs319.cards.model.AnswerCard;
import cs319.cards.model.QuestionCard;
import org.springframework.lang.Nullable;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.net.MalformedURLException;
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
     *
     * @param fileName name of the file.
     * @return list of cards.
     */
    public static List<QuestionCard> loadQuestionCardsJson(@Nullable String fileName) {
        URL file = null;
        if (fileName == null) {
            ClassLoader loader = ClassLoader.getSystemClassLoader();
            file = loader.getResource("question_cards.json");
        } else {
            try {
                file = new File(fileName).toURL();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
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
     *
     * @param fileName name of the file.
     * @return list of cards.
     */
    public static List<AnswerCard> loadAnswerCardsJson(@Nullable String fileName) {
        URL file = null;
        if (fileName == null) {
            ClassLoader loader = ClassLoader.getSystemClassLoader();
            file = loader.getResource("answer_cards.json");
        } else {
            try {
                file = new File(fileName).toURL();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
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
