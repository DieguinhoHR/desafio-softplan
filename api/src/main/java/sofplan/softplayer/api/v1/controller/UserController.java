package sofplan.softplayer.api.v1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sofplan.softplayer.domain.model.User;
import sofplan.softplayer.domain.service.UserService;

@RestController
@RequestMapping("/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    @Operation(
        summary = "Grava um usuário no banco de dados",
        description = "Este endpoint serve para gravar um usuário para testar a API",
        tags = {"User"}
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Operação realizada com sucesso"),
    })
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
}
