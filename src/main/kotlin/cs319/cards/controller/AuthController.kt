package cs319.cards.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController {

    @PostMapping("/login")
    fun login(@RequestBody userName: String) {
        return
    }

    @PostMapping("/logout")
    fun logout(@RequestBody userName: String) {
        return
    }
}