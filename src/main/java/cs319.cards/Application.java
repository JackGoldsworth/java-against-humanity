package cs319.cards;

import cs319.cards.model.Card;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        List<Card> cards = JsonUtils.loadCardsJson(); //TODO stuffs with this.
        SpringApplication.run(Application.class, args);
    }
}
