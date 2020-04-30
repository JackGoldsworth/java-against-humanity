package cs319.cards.controller;

import cs319.cards.CardManager;
import cs319.cards.Game;
import cs319.cards.PartyManager;
import cs319.cards.model.Party;
import cs319.cards.model.PartyInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class SocketController {

    @MessageMapping("/czar")
    @SendTo("/results")
    public ResponseEntity<PartyInfo> send(String username) {
        Optional<Party> party = PartyManager.getPartyByUsername(username);
        if (party.isPresent()) {
            Party playerParty = party.get();
            Game game = playerParty.getGame();
            if (game != null) {
                PartyInfo info = new PartyInfo(playerParty.getHostname(),
                        playerParty.getUsers(),
                        game.getBlackCard(),
                        game.getCzar().getUsername(),
                        game.getCzarChoices().values().stream().map(CardManager::getAnswerCardById).collect(Collectors.toList()),
                        game.getWinner());
                return ResponseEntity.ok(info);
            }
        }
        return ResponseEntity.noContent().build();
    }
}
