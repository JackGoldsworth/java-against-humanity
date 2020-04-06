package cs319.cards.service;

import cs319.cards.model.JoinForm;
import cs319.cards.model.Party;
import javafx.util.Pair;

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
     * @param username hosts name
     * @return if the party creation was successful and the party they joined.
     */
    Pair<Party, Boolean> createParty(String username);

    /**
     * Allows a user to join a party using a join form.
     *
     * @param joinForm class containing the username and the party id.
     * @return whether the join was successful or not.
     */
    Pair<Party, Boolean> joinParty(JoinForm joinForm);
}
