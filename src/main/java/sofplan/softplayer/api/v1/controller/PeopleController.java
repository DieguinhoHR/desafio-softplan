package sofplan.softplayer.api.v1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sofplan.softplayer.domain.model.People;
import sofplan.softplayer.domain.repository.PeopleRepository;
import sofplan.softplayer.domain.service.PeopleService;

import java.util.List;

@RestController
@RequestMapping("/people")
@AllArgsConstructor
public class PeopleController {
    private final PeopleService peopleService;

    @GetMapping
    public List<People> list() {
        return peopleService.list();
    }
}
