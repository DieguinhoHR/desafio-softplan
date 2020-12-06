package sofplan.softplayer.domain.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import sofplan.softplayer.domain.model.People;
import sofplan.softplayer.domain.model.enums.Gender;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@DisplayName("Test for People Repository")
class PeopleRepositoryTest {
    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    @DisplayName("Deve salvar uma pessoa com sucesso")
    void should_persist_when_successful() {
        People peopleToBeSaved = createPeople();
        People peopleSaved = this.peopleRepository.save(peopleToBeSaved);

        Assertions.assertThat(peopleSaved).isNotNull();
        Assertions.assertThat(peopleSaved.getId()).isNotNull();
        Assertions.assertThat(peopleSaved.getName()).isEqualTo(peopleToBeSaved.getName());
        Assertions.assertThat(peopleSaved.getEmail()).isEqualTo(peopleToBeSaved.getEmail());
    }

    @Test
    @DisplayName("Deve atualizar uma pessoa com sucesso")
    void should_updated_people_when_successful() {
        People peopleToBeSaved = createPeople();
        People peopleSaved = this.peopleRepository.save(peopleToBeSaved);

        peopleSaved.setName("Vegeta");

        People peopleUpdated = this.peopleRepository.save(peopleSaved);

        Assertions.assertThat(peopleUpdated).isNotNull();
        Assertions.assertThat(peopleUpdated.getId()).isNotNull();
        Assertions.assertThat(peopleUpdated.getName()).isEqualTo(peopleSaved.getName());
    }

    @Test
    @DisplayName("Deve remover uma pessoa com sucesso")
    void should_remove_people_when_successful() {
        People peopleToBeSaved = createPeople();
        People peopleSaved = this.peopleRepository.save(peopleToBeSaved);

        this.peopleRepository.delete(peopleSaved);

        Optional<People> peopleOptional = this.peopleRepository.findById(peopleSaved.getId());

        Assertions.assertThat(peopleOptional).isEmpty();
    }

    @Test
    @DisplayName("Deve buscar uma pessoa pelo nome com sucesso")
    void should_find_by_name_people_when_successful() {
        People peopleToBeSaved = createPeople();
        People peopleSaved = this.peopleRepository.save(peopleToBeSaved);

        String name = peopleSaved.getName();

        List<People> people = this.peopleRepository.findByName(name);

        Assertions.assertThat(people).isNotEmpty();
        Assertions.assertThat(people).contains(peopleSaved);
    }

    @Test
    @DisplayName("Deve retornar uma lista vazia")
    void should_returns_empty_list_when_people_is_not_found() {
        List<People> people = this.peopleRepository.findByName("pen");
        Assertions.assertThat(people).isEmpty();
    }

    private People createPeople() {
        return People.builder()
                .name("Majin boo")
                .gender(Gender.MALE)
                .email("majinboo@dragonball.com")
                .dateBirth(LocalDate.now())
                .naturalness("Porto alegre")
                .nationality("Brasileiro")
                .cpf("335.747.130-29")
                .build();
   }

}