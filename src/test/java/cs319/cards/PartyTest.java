package cs319.cards;

import cs319.cards.model.Party;
import cs319.cards.model.User;
import cs319.cards.model.form.JoinForm;
import cs319.cards.service.PartyService;
import javafx.util.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PartyTest {

    @DisplayName("Test Creating a Party")
    @Test
    public void testCreateParty() {
        PartyService partyService = Mockito.mock(PartyService.class);
        Mockito.when(partyService.createParty("Test", null, 5, 3)).then(x -> {
            Party party = new Party("Test", null, 5, 3);
            User user = new User("Test");
            party.addUser(user);
            PartyManager.parties.add(party);
            return new Pair<>(party, true);
        });
        partyService.createParty("Test", null, 5, 3);
        Assertions.assertTrue(PartyManager.getPartyByUsername("Test").isPresent());
    }

    @DisplayName("Test Joining a Party")
    @Test
    public void testJoinParty() {
        PartyService partyService = Mockito.mock(PartyService.class);
        JoinForm form = new JoinForm("Test1", "");
        Mockito.when(partyService.joinParty(form)).then(x -> {
            Party party = new Party("Test", null, 5, 3);
            party.addUser(new User("Test1"));
            PartyManager.parties.add(party);
            return new Pair<>(party, true);
        });
        Pair<Party, Boolean> result = partyService.joinParty(form);
        Assertions.assertNotNull(result.getKey().getUserByName("Test1"));
    }
}
