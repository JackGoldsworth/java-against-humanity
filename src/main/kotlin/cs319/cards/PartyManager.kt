package cs319.cards

import cs319.cards.model.Party

object PartyManager {

    val parties = mutableListOf<Party>()

    fun getPartyByUsername(userName: String): Party? {
        return parties.firstOrNull { it.hostUsername == userName }
    }
}