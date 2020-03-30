package cs319.cards.controller;

import cs319.cards.PartyManager;
import cs319.cards.model.Party;
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
        if(party == null) {
            PartyManager.parties.add(new Party(userName));
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body("Party already exists under $userName");
    }
}
