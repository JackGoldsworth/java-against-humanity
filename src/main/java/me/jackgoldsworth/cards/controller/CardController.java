package me.jackgoldsworth.cards.controller;

import me.jackgoldsworth.cards.CardManager;
import me.jackgoldsworth.cards.Game;
import me.jackgoldsworth.cards.PartyManager;
import me.jackgoldsworth.cards.model.AnswerCard;
import me.jackgoldsworth.cards.model.Party;
import me.jackgoldsworth.cards.model.PartyInfo;
import me.jackgoldsworth.cards.model.User;
import me.jackgoldsworth.cards.model.form.PlayCardForm;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public CardController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @PostMapping("/get")
    public ResponseEntity<List<AnswerCard>> getPlayersCard(@RequestBody String username) {
        Optional<Party> party = PartyManager.getPartyByUsername(username);
        if (party.isPresent()) {
            Party playerParty = party.get();
            List<AnswerCard> answerCards = CardManager.convertIdToAnswerCards(playerParty.getUserByName(username).getCurrentCards());
            return ResponseEntity.ok(answerCards);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/play")
    public ResponseEntity<Boolean> playCard(@RequestBody PlayCardForm cardForm) {
        String username = cardForm.getUsername();
        Optional<Party> party = PartyManager.getPartyByUsername(username);
        if (party.isPresent()) {
            Party playerParty = party.get();
            User user = playerParty.getUserByName(username);
            AnswerCard answerCard = CardManager.getAnswerCardByMessage(cardForm.getCardMessage());
            if (answerCard != null) {
                playerParty.getGame().playCardSingle(answerCard, user);
                forceUpdate(username);
                return ResponseEntity.ok(true);
            }
            return ResponseEntity.ok(false);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/vote")
    public ResponseEntity<Boolean> voteOnCard(@RequestBody PlayCardForm cardForm) {
        String username = cardForm.getUsername();
        Optional<Party> party = PartyManager.getPartyByUsername(username);
        if (party.isPresent()) {
            Party playerParty = party.get();
            AnswerCard answerCard = CardManager.getAnswerCardByMessage(cardForm.getCardMessage());
            if (answerCard != null) {
                playerParty.getGame().czarSelectSingle(answerCard);
                forceUpdate(username);
                return ResponseEntity.ok(true);
            }
            return ResponseEntity.ok(false);
        }
        return ResponseEntity.notFound().build();
    }

    private void forceUpdate(String username) {
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
                simpMessagingTemplate.convertAndSend("/results", info);
            }
        }
    }
}

