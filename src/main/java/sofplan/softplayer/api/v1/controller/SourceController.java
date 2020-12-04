package sofplan.softplayer.api.v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/source")
public class SourceController {
    @GetMapping
    public String source() {
        return "<HTML><body><a href=\"https://github.com/DieguinhoHR/softplayer-api\">Link para o projeto</a></body></HTML>";
    }
}
