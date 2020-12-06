package sofplan.softplayer.api.v1.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sofplan.softplayer.api.v1.dto.PeopleDTO;
import sofplan.softplayer.api.v1.dto.PeopleNewDTO;
import sofplan.softplayer.domain.model.People;
import sofplan.softplayer.domain.service.PeopleService;
import sofplan.softplayer.util.PeopleCreator;
import sofplan.softplayer.util.PeoplePostRequestBodyCreator;
import sofplan.softplayer.util.PeoplePutRequestBodyCreator;

import java.util.List;

@ExtendWith(SpringExtension.class)
class PeopleControllerTest {
    @InjectMocks
    private PeopleController peopleController;
    @Mock
    private PeopleService peopleServiceMock;

    @BeforeEach
    void setUp() {
        PageImpl<People> peoplePage = new PageImpl<>(List.of(PeopleCreator.createValidPeople()));
        BDDMockito.when(peopleServiceMock.listAll(ArgumentMatchers.any()))
                .thenReturn(peoplePage);

        BDDMockito.when(peopleServiceMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(PeopleCreator.createValidPeople());

        BDDMockito.when(peopleServiceMock.findByName(ArgumentMatchers.anyString()))
                .thenReturn(List.of(PeopleCreator.createValidPeople()));

        BDDMockito.when(peopleServiceMock.save(ArgumentMatchers.any(PeopleNewDTO.class)))
                .thenReturn(PeopleCreator.createValidPeople());

        BDDMockito.doNothing().when(peopleServiceMock)
                .update(ArgumentMatchers.any(PeopleDTO.class));

        BDDMockito.doNothing().when(peopleServiceMock)
                .delete(ArgumentMatchers.anyLong());
    }
    @Test
    @DisplayName("Listagem da página de objetos")
    void should_list_people_inside_page_object_when_successful() {
        String expectedName = PeopleCreator.createValidPeople().getName();

        Page<People> peoplePage = peopleController.list(null).getBody();

        Assertions.assertThat(peoplePage).isNotNull();

        Assertions.assertThat(peoplePage.toList())
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(peoplePage.toList()
                .get(0)
                .getName())
                .isEqualTo(expectedName);
    }

    @Test
    @DisplayName("Busca por uma pessoa pelo id com sucesso")
    void should_find_by_id_when_successful() {
        Long expectedId = PeopleCreator.createValidPeople().getId();

        People people = peopleController.findById(1).getBody();

        Assertions.assertThat(people).isNotNull();
        Assertions.assertThat(people.getId()).isNotNull().isEqualTo(expectedId);
    }

    @Test
    @DisplayName("Busca por uma pessoa pelo nome com sucesso")
    void should_find_by_name_when_successful() {
        String expectedName = PeopleCreator.createValidPeople().getName();

        List<People> animes = peopleController.findByName("anime").getBody();

        Assertions.assertThat(animes)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(animes.get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("Salva um pessoa com sucesso")
    void should_save_a_new_people_when_successful() {
        People people = peopleController.save(PeoplePostRequestBodyCreator.createPeoplePostRequestBody()).getBody();

        Assertions.assertThat(people).isNotNull().isEqualTo(PeopleCreator.createValidPeople());
    }

    @Test
    @DisplayName("atualiza uma pessoa com sucesso")
    void should_update_people_when_successful(){

        Assertions.assertThatCode(() -> peopleController.update(PeoplePutRequestBodyCreator.createPeoplePutRequestBody()))
                .doesNotThrowAnyException();

        ResponseEntity<Void> entity = peopleController.update(PeoplePutRequestBodyCreator.createPeoplePutRequestBody());

        Assertions.assertThat(entity).isNotNull();
        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("deleta uma pessao com sucesso")
    void should_deleted_people_when_successful(){

        Assertions.assertThatCode(() -> peopleController.delete(1))
                .doesNotThrowAnyException();
        ResponseEntity<Void> entity = peopleController.delete(1);

        Assertions.assertThat(entity).isNotNull();
        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

}