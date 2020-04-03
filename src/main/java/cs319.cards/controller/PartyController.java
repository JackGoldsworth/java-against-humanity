package cs319.cards.controller;

import cs319.cards.PartyManager;
import cs319.cards.model.JoinForm;
import cs319.cards.model.Party;
import cs319.cards.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/parties")
public class PartyController {

    @PostMapping("/create")
    public ResponseEntity<String> createParty(@RequestBody String userName) {
        Optional<Party> optionalParty = PartyManager.getPartyByUsername(userName);
        if (optionalParty.isEmpty()) {
            Party party = new Party(userName);
            party.addUser(new User(userName));
            PartyManager.parties.add(party);
            return ResponseEntity.ok(party.getPartyId());
        }
        return ResponseEntity.badRequest().body("Party already exists under $userName");
    }

    @PostMapping("/join")
    public ResponseEntity<String> joinParty(@RequestBody JoinForm joinForm) {
        Optional<Party> optionalParty = PartyManager.getPartyById(joinForm.getId());
        if (optionalParty.isPresent()) {
            optionalParty.get().addUser(new User(joinForm.getUsername()));
            return ResponseEntity.ok(joinForm.getUsername() + " successfully joined the party with id: " + joinForm.getId() + " That is hosted by: " + optionalParty.get().getHostname());
        }
        return ResponseEntity.badRequest().body("Party already exists under $userName");
    }
}
