package cs319.cards.service;

import cs319.cards.PartyManager;
import cs319.cards.model.JoinForm;
import cs319.cards.model.Party;
import cs319.cards.model.User;
import javafx.util.Pair;

import java.util.Optional;

public class PartyServiceImpl implements PartyService {

    @Override
    public Pair<Party, Boolean> createParty(String userName) {
        Optional<Party> optionalParty = PartyManager.getPartyByUsername(userName);
        if (!optionalParty.isPresent()) {
            Party party = new Party(userName);
            party.addUser(new User(userName));
            PartyManager.parties.add(party);
            return new Pair<>(party, true);
        }
        return new Pair<>(null, false);
    }

    @Override
    public Pair<Party, Boolean> joinParty(JoinForm joinForm) {
        Optional<Party> optionalParty = PartyManager.getPartyById(joinForm.getId());
        if (optionalParty.isPresent()) {
            optionalParty.get().addUser(new User(joinForm.getUsername()));
            return new Pair<>(optionalParty.get(), true);
        }
        return new Pair<>(null, false);
    }
}
