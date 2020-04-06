package cs319.cards;

import cs319.cards.model.JoinForm;
import cs319.cards.model.Party;
import cs319.cards.model.User;
import cs319.cards.service.PartyService;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class PartyTest {

    @Test
    public void testCreateParty() {
        PartyService partyService = Mockito.mock(PartyService.class);
        Mockito.when(partyService.createParty("Test")).then(x -> {
            Party party = new Party("Test");
            PartyManager.parties.add(party);
            return new Pair<>(party, true);
        });
        partyService.createParty("Test");
        Assert.assertTrue(PartyManager.getPartyByUsername("Test").isPresent());
    }

    @Test
    public void testJoinParty() {
        PartyService partyService = Mockito.mock(PartyService.class);
        JoinForm form = new JoinForm("Test1", "");
        Mockito.when(partyService.joinParty(form)).then(x -> {
            Party party = new Party("Test");
            party.addUser(new User("Test1"));
            PartyManager.parties.add(party);
            return new Pair<>(party, true);
        });
        Pair<Party, Boolean> result = partyService.joinParty(form);
        Assert.assertNotNull(result.getKey().getUserByName("Test1"));
    }
}
