package cs319.cards.controller;

import cs319.cards.PartyManager;
import cs319.cards.model.Party;
import cs319.cards.model.PartyInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class SocketController {

    @MessageMapping("/czar")
    @SendTo("/results")
    public ResponseEntity<PartyInfo> send(String username) {
        Optional<Party> party = PartyManager.getPartyByUsername(username);
        if (party.isPresent()) {
            Party playerParty = party.get();
            PartyInfo info = new PartyInfo(playerParty.getHostname(),
                    playerParty.getUsers(),
                    playerParty.getGame().getBlackCard(),
                    playerParty.getGame().getCzar().getUsername());
            return ResponseEntity.ok(info);
        }
        return ResponseEntity.noContent().build();
    }
}
