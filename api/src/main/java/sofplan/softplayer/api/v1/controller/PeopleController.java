package sofplan.softplayer.api.v1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(
        summary = "Lista todas as pessoas paginadas",
        description = "O tamanho padrão é 20, use o parametro size para mudar o valor padrão",
        tags = {"People"}
    )
    public ResponseEntity<Page<People>> list(@ParameterObject Pageable pageable) {
        log.info("List all people");
        return ResponseEntity.ok(peopleService.listAll(pageable));
    }

    @GetMapping(path = "admin/people/{id}")
    @Operation(
        summary = "Busca uma única pessoa pelo id",
        description = "Este endpoint busca um único registro",
        tags = {"People"}
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
    })
    public ResponseEntity<People> findById(@PathVariable long id) {
        log.info("Show a unique person");
        return ResponseEntity.ok(peopleService.findById(id));
    }

    @GetMapping(path = "admin/people/find")
    @Operation(
        summary = "Busca um único registro pelo nome",
        description = "Este endpoint busca um único registro",
        tags = {"People"}
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Quando a pessoa não existe na base de dados")
    })
    public ResponseEntity<List<People>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(peopleService.findByName(name));
    }

    @PostMapping(path = "admin/people")
    @Operation(
        summary = "Grava uma pessoa",
        description = "Este endpoint persisti uma pessoa na base de dados",
        tags = {"People"}
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Operação realizada com sucesso"),
    })
    public ResponseEntity<People> save(@RequestBody @Valid PeopleNewDTO peoplePostRequestBody) {
        return new ResponseEntity<>(peopleService.save(peoplePostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping(path = "admin/people")
    @Operation(
        summary = "Atualiza uma pessoa",
        description = "Este endpoint atualiza um registro na base de dados",
        tags = {"People"}
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Operação realizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Quando a pessoa não existe na base de dados")
    })
    public ResponseEntity<Void> update(@RequestBody PeopleDTO peopleDTO) {
        peopleService.update(peopleDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "admin/people/{id}")
    @Operation(
        summary = "Deleta uma pessoa",
        description = "Este endpoint remove um registro da base de dados",
        tags = {"People"}
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Operação realizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Quando a pessoa não existe na base de dados")
    })
    public ResponseEntity<Void> delete(@PathVariable long id) {
        peopleService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
