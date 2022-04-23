package upc.ms.fast.beat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HolaMundo {

    @GetMapping("/message")
    public String home(){
        return "Hola";
    }

}
