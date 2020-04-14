package cs319.cards.controller;

import cs319.cards.CardManager;
import cs319.cards.PartyManager;
import cs319.cards.model.Card;
import cs319.cards.model.Party;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cards")
public class CardController {

    public ResponseEntity<List<Card>> getPlayersCard(@RequestBody String username) {
        Optional<Party> party = PartyManager.getPartyByUsername(username);
        if (party.isPresent()) {
            Party playerParty = party.get();
            List<Card> cards = CardManager.convertIdToCards(playerParty.getUserByName(username).getCurrentCards());
            return ResponseEntity.ok(cards);
        }
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Boolean> removeCardFromPlayer(@RequestBody short cardId, @RequestBody String username) {
        Optional<Party> party = PartyManager.getPartyByUsername(username);
        if (party.isPresent()) {
            Party playerParty = party.get();
            boolean result = playerParty.getUserByName(username).getCurrentCards().remove(new Short(cardId));
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }
}
