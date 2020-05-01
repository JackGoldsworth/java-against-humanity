package me.jackgoldsworth.cards.controller;

import me.jackgoldsworth.cards.CardManager;
import me.jackgoldsworth.cards.Game;
import me.jackgoldsworth.cards.PartyManager;
import me.jackgoldsworth.cards.model.Party;
import me.jackgoldsworth.cards.model.PartyInfo;
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
