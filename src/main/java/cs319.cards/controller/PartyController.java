package cs319.cards.controller;

import cs319.cards.model.JoinForm;
import cs319.cards.model.Party;
import cs319.cards.service.PartyServiceImpl;
import javafx.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parties")
public class PartyController {

    private final PartyServiceImpl partyService = new PartyServiceImpl();

    @PostMapping("/create")
    public ResponseEntity<String> createParty(@RequestBody String userName) {
        Pair<Party, Boolean> result = partyService.createParty(userName);
        return result.getValue() ? ResponseEntity.ok(result.getKey().getPartyId()) : ResponseEntity.badRequest().body("Party already exists under $userName");
    }

    @PostMapping("/join")
    public ResponseEntity<String> joinParty(@RequestBody JoinForm joinForm) {
        Pair<Party, Boolean> result = partyService.joinParty(joinForm);
        if (result.getValue()) {
            return ResponseEntity.ok(joinForm.getUsername() + " successfully joined the party with id: " + joinForm.getId() + " That is hosted by: " + result.getKey().getHostname());
        }
        return ResponseEntity.badRequest().body("Party already exists under $userName");
    }
}
