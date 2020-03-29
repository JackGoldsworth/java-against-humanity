package cs319.cards.controller

import cs319.cards.PartyManager
import cs319.cards.model.Party
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PartyController {

    @PostMapping
    fun createParty(@RequestBody userName: String): ResponseEntity<String> {
        val party: Party? = PartyManager.getPartyByUsername(userName)
        return if(party == null) {
            PartyManager.parties.add(Party(userName, mutableListOf()))
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.badRequest().body("Party already exists under $userName")
        }
    }
}