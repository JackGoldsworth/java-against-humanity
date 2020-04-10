package cs319.cards;

import com.google.gson.Gson;
import cs319.cards.model.Card;
import cs319.cards.model.CardManager;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Basic JSON based utility methods.
 * @author Jack Goldsworth
 */
public class JsonUtils {

    private JsonUtils() {}

    /**
     * This method loads the cards json file into
     * memory to be used throughout the duration of the program.
     * This reduces the disk I/O.
     * @return list of cards.
     */
    public static List<Card> loadCardsJson() {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        URL file = loader.getResource("general_cards.json");
        Gson gson = new Gson();
        if(file != null) {
            try {
                Reader reader = Files.newBufferedReader(Paths.get(file.toURI()));
                List<Card> cards = gson.fromJson(reader, CardManager.class).getCards();
                cards.forEach(card -> System.out.println(card.getCardMessage()));
                return cards;
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
