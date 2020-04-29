package cs319.cards.service;

import cs319.cards.model.Party;
import cs319.cards.model.User;
import cs319.cards.model.form.JoinForm;
import javafx.util.Pair;

import java.util.List;

/**
 * Service class so that the services
 * can be mocked.
 *
 * @author Jack Goldsworth
 */
public interface PartyService {

    /**
     * Creates a party using the hosts username.
     *
     * @param username   hosts name
     * @param cardPacks  set of card packs allowed.
     * @param maxPlayers max players allowed in a party.
     * @param scoreToWin score to win the game.
     * @return if the party creation was successful and the party they joined.
     */
    Pair<Party, Boolean> createParty(String username, List<Integer> cardPacks, int maxPlayers, int scoreToWin);

    /**
     * Allows a user to join a party using a join form.
     *
     * @param joinForm class containing the username and the party id.
     * @return whether the join was successful or not.
     */
    Pair<Party, User> joinParty(JoinForm joinForm);
}
