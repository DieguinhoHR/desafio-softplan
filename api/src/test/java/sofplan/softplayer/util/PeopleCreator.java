package sofplan.softplayer.util;

import sofplan.softplayer.domain.model.People;
import sofplan.softplayer.domain.model.enums.Gender;

import java.time.LocalDate;

public class PeopleCreator {
    public static People createPeopleToBeSaved() {
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

    public static People createValidPeople() {
        return People.builder()
                .name("Majin boo")
                .gender(Gender.MALE)
                .email("majinboo@dragonball.com")
                .dateBirth(LocalDate.now())
                .naturalness("Porto alegre")
                .nationality("Brasileiro")
                .cpf("335.747.130-29")
                .id(1L)
                .build();
    }

    public static People createValidUpdatedPeople() {
        return People.builder()
                .name("Majin boo")
                .gender(Gender.MALE)
                .email("majinboo@dragonball.com")
                .dateBirth(LocalDate.now())
                .naturalness("Porto alegre")
                .nationality("Brasileiro")
                .cpf("335.747.130-29")
                .id(1L)
                .build();
    }
}
