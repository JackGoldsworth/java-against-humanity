package cs319.cards.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController {

    @PostMapping
    fun login(@RequestBody userName: String) {

    }

    @PostMapping
    fun logout(@RequestBody userName: String) {

    }
}