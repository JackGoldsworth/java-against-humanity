package cs319.cards.controller;

import cs319.cards.PartyManager;
import cs319.cards.model.Party;
import cs319.cards.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parties")
public class PartyController {

    @PostMapping("/create")
    public ResponseEntity<String> createParty(@RequestBody String userName) {
        Party party = PartyManager.getPartyByUsername(userName);
        if (party == null) {
            party = new Party(userName);
            PartyManager.parties.add(party);
            return ResponseEntity.ok(party.getPartyId());
        }
        return ResponseEntity.badRequest().body("Party already exists under $userName");
    }

    @PostMapping("/join")
    public ResponseEntity<String> joinParty(@RequestBody String id, @RequestBody String username) {
        Party party = PartyManager.getPartyById(id);
        if (party != null) {
            party.addUser(new User(username));
            return ResponseEntity.ok("Party: " + id + "successfully joined!");
        }
        return ResponseEntity.badRequest().body("Party already exists under $userName");
    }
}
