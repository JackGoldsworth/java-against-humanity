package cs319.cards.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SocketController {

    @MessageMapping("/czar")
    @SendTo("/results")
    public String send(String message) {
        return "Test";
    }
}
