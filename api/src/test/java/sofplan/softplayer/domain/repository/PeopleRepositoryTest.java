package sofplan.softplayer.domain.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import sofplan.softplayer.domain.model.People;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

import static sofplan.softplayer.util.PeopleCreator.createPeopleToBeSaved;

@DataJpaTest
@DisplayName("Test for People Repository")
class PeopleRepositoryTest {
    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    @DisplayName("Deve salvar uma pessoa com sucesso")
    void should_persist_when_successful() {
        People peopleToBeSaved = createPeopleToBeSaved();
        People peopleSaved = this.peopleRepository.save(peopleToBeSaved);

        Assertions.assertThat(peopleSaved).isNotNull();
        Assertions.assertThat(peopleSaved.getId()).isNotNull();
        Assertions.assertThat(peopleSaved.getName()).isEqualTo(peopleToBeSaved.getName());
        Assertions.assertThat(peopleSaved.getEmail()).isEqualTo(peopleToBeSaved.getEmail());
    }

    @Test
    @DisplayName("Deve atualizar uma pessoa com sucesso")
    void should_updated_people_when_successful() {
        People peopleToBeSaved = createPeopleToBeSaved();
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
        People peopleToBeSaved = createPeopleToBeSaved();
        People peopleSaved = this.peopleRepository.save(peopleToBeSaved);

        this.peopleRepository.delete(peopleSaved);

        Optional<People> peopleOptional = this.peopleRepository.findById(peopleSaved.getId());

        Assertions.assertThat(peopleOptional).isEmpty();
    }

    @Test
    @DisplayName("Deve buscar uma pessoa pelo nome com sucesso")
    void should_find_by_name_people_when_successful() {
        People peopleToBeSaved = createPeopleToBeSaved();
        People peopleSaved = this.peopleRepository.save(peopleToBeSaved);

        String name = peopleSaved.getName();

        List<People> people = this.peopleRepository.findByName(name);

        Assertions.assertThat(people)
                .isNotEmpty()
                .contains(peopleSaved);
    }

    @Test
    @DisplayName("Deve retornar uma lista vazia")
    void should_returns_empty_list_when_people_is_not_found() {
        List<People> people = this.peopleRepository.findByName("pen");
        Assertions.assertThat(people).isEmpty();
    }

    @Test
    @DisplayName("Save throw ConstraintViolationException quando cpf está vazio")
    void should_throws_constraint_violation_exception_when_cpf_is_empty(){
        People people = new People();
        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(() -> this.peopleRepository.save(people))
                .withMessageContaining("O campo cpf não pode ser vazio");
    }
}