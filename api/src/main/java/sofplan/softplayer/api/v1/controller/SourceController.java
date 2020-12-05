package sofplan.softplayer.api.v1.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/source")
public class SourceController {
    @GetMapping
    @Operation(
        summary = "Código fonte no github",
        description = "Este código fonte redirecion o usuário para o github onde está todo fonte deste projeto",
        tags = {"Source"}
    )
    public String source() {
        return "<HTML><body><a href=\"https://github.com/DieguinhoHR/softplayer-api\">Link para o projeto</a></body></HTML>";
    }
}
