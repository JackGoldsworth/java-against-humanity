package me.jackgoldsworth.cards;

import me.jackgoldsworth.cards.model.Party;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PartyManager {

    public static final List<Party> parties = new ArrayList<>();

    private PartyManager() {
        // Makes sure the class cannot be instantiated.
    }

    public static Optional<Party> getPartyByHostname(String userName) {
        return parties.stream().filter(party -> party.getHostname().equals(userName)).findFirst();
    }

    public static Optional<Party> getPartyById(String id) {
        return parties.stream().filter(party -> party.getPartyId().equals(id)).findFirst();
    }

    public static Optional<Party> getPartyByUsername(String userName) {
        return parties.stream().filter(party -> party.containsUser(userName)).findFirst();
    }

    public static void removeParty(String username) {
        parties.stream().filter(p -> p.containsUser(username)).findFirst().ifPresent(parties::remove);
    }
}
