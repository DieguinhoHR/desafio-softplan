package sofplan.softplayer.api.v1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sofplan.softplayer.domain.model.People;
import sofplan.softplayer.domain.service.PeopleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/v1/people", produces = MediaType.APPLICATION_JSON_VALUE)
@Log4j2
@RequiredArgsConstructor
public class PeopleController {
    private final PeopleService peopleService;

    @GetMapping
    public ResponseEntity<List<People>> list() {
        log.info("List all people");
        return new ResponseEntity<>(peopleService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<People>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(peopleService.findById(id));
    }
}
