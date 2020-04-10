package cs319.cards;

import cs319.cards.model.Card;
import cs319.cards.model.Party;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PartyManager {

    public static final List<Party> parties = new ArrayList<>();

    public static Optional<Party> getPartyByUsername(String userName) {
        return parties.stream().filter(party -> party.getHostname().equals(userName)).findFirst();
    }

    public static Optional<Party> getPartyById(String id) {
        return parties.stream().filter(party -> party.getPartyId().equals(id)).findFirst();
    }
}
