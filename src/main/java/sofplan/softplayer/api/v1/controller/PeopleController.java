package sofplan.softplayer.api.v1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sofplan.softplayer.api.v1.requests.PeoplePostRequestBody;
import sofplan.softplayer.api.v1.requests.PeoplePutRequestBody;
import sofplan.softplayer.domain.model.People;
import sofplan.softplayer.domain.service.PeopleService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/people")
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
    public ResponseEntity<People> findById(@PathVariable long id) {
        return ResponseEntity.ok(peopleService.findById(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<People>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(peopleService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<People> save(@RequestBody @Valid PeoplePostRequestBody peoplePostRequestBody) {
        return new ResponseEntity<>(peopleService.save(peoplePostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody PeoplePutRequestBody peoplePutRequestBody) {
        peopleService.update(peoplePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        peopleService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
