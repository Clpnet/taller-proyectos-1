package upc.ms.fast.beat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upc.ms.fast.beat.utils.WhatsAppUtil;

@Controller
@RequestMapping("/home")
public class HolaMundo {


    @Autowired
    private WhatsAppUtil whatsAppUtil;


    @GetMapping("/message")
    public String home(){
        whatsAppUtil.sendWhatsApp("+51934758933", "test");
        return "Hola";
    }

}
