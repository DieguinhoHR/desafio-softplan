package sofplan.softplayer.api.v1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sofplan.softplayer.domain.model.User;
import sofplan.softplayer.domain.service.UserService;

@RestController
@RequestMapping("/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
}
