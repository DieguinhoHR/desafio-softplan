package sofplan.softplayer.domain.service;

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
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sofplan.softplayer.domain.model.People;
import sofplan.softplayer.domain.repository.PeopleRepository;
import sofplan.softplayer.util.PeopleCreator;
import sofplan.softplayer.util.PeoplePostRequestBodyCreator;
import sofplan.softplayer.util.PeoplePutRequestBodyCreator;

import java.util.*;

@ExtendWith(SpringExtension.class)
class PeopleServiceTest {
    @InjectMocks
    private PeopleService peopleService;
    @Mock
    private PeopleRepository peopleRepositoryMock;

    @BeforeEach
    void setUp() {
        PageImpl<People> peoplePage = new PageImpl<>(List.of(PeopleCreator.createValidPeople()));
        BDDMockito.when(peopleRepositoryMock.findAll(ArgumentMatchers.any(PageRequest.class)))
                .thenReturn(peoplePage);

        BDDMockito.when(peopleRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(PeopleCreator.createValidPeople()));

        BDDMockito.when(peopleRepositoryMock.findByName(ArgumentMatchers.anyString()))
                .thenReturn(List.of(PeopleCreator.createValidPeople()));

        BDDMockito.when(peopleRepositoryMock.save(ArgumentMatchers.any(People.class)))
                .thenReturn(PeopleCreator.createValidPeople());

        BDDMockito.doNothing().when(peopleRepositoryMock)
                .delete(ArgumentMatchers.any(People.class));
    }
    @Test
    @DisplayName("Listagem da página de objetos")
    void should_list_people_inside_page_object_when_successful() {
        String expectedName = PeopleCreator.createValidPeople().getName();

        Page<People> animePage = peopleService.listAll(PageRequest.of(1,1));

        Assertions.assertThat(animePage).isNotNull();

        Assertions.assertThat(animePage.toList())
                .isNotEmpty()
                .hasSize(1);

        //Assertions.assertThat(animePage.toList().get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("Busca por uma pessoa pelo id com sucesso")
    void should_find_by_id_when_successful() {
        Long expectedId = PeopleCreator.createValidPeople().getId();

        People people = peopleService.findById(1);

        Assertions.assertThat(people).isNotNull();
        Assertions.assertThat(people.getId()).isNotNull().isEqualTo(expectedId);
    }

    @Test
    @DisplayName("Busca por uma pessoa pelo nome com sucesso")
    void should_find_by_name_when_successful() {
        String expectedName = PeopleCreator.createValidPeople().getName();

        List<People> people = peopleService.findByName("anime");

        Assertions.assertThat(people)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(people.get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("Salva um pessoa com sucesso")
    void should_save_a_new_people_when_successful() {
        People people = peopleService.save(PeoplePostRequestBodyCreator.createPeoplePostRequestBody());

        Assertions.assertThat(people).isNotNull().isEqualTo(PeopleCreator.createValidPeople());
    }

    @Test
    @DisplayName("atualiza uma pessoa com sucesso")
    void should_update_people_when_successful() {
        Assertions.assertThatCode(() -> peopleService.update(PeoplePutRequestBodyCreator.createPeoplePutRequestBody()))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("deleta uma pessao com sucesso")
    void should_deleted_people_when_successful() {
        Assertions.assertThatCode(() -> peopleService.delete(1))
                .doesNotThrowAnyException();
    }
}