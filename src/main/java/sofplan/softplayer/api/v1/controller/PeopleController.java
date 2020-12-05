package sofplan.softplayer.api.v1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import sofplan.softplayer.api.v1.dto.PeopleDTO;
import sofplan.softplayer.api.v1.dto.PeopleNewDTO;
import sofplan.softplayer.domain.model.People;
import sofplan.softplayer.domain.service.PeopleService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "v1")
@Log4j2
@RequiredArgsConstructor
public class PeopleController {
    private final PeopleService peopleService;

    @GetMapping(path = "admin/people")
    public ResponseEntity<Page<People>> list(Pageable pageable) {
        log.info("List all people");
        return ResponseEntity.ok(peopleService.listAll(pageable));
    }

    @GetMapping(path = "admin/people/{id}")
    public ResponseEntity<People> findById(@PathVariable long id) {
        log.info("Show a unique person");
        return ResponseEntity.ok(peopleService.findById(id));
    }

    @GetMapping(path = "admin/people/find")
    public ResponseEntity<List<People>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(peopleService.findByName(name));
    }

    @PostMapping(path = "admin/people")
    public ResponseEntity<People> save(@RequestBody @Valid PeopleNewDTO peoplePostRequestBody) {
        return new ResponseEntity<>(peopleService.save(peoplePostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping(path = "admin/people")
    public ResponseEntity<Void> update(@RequestBody PeopleDTO peopleDTO) {
        peopleService.update(peopleDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "admin/people/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        peopleService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
