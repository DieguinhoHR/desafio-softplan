package sofplan.softplayer.domain.model.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sofplan.softplayer.api.v1.dto.PeopleDTO;
import sofplan.softplayer.api.v1.dto.PeopleNewDTO;
import sofplan.softplayer.domain.model.People;
import sofplan.softplayer.domain.model.People.PeopleBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-06T18:35:55-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class PeopleMapperImpl implements PeopleMapper {

    @Override
    public People toPeople(PeopleNewDTO peoplePostRequestBody) {
        if ( peoplePostRequestBody == null ) {
            return null;
        }

        PeopleBuilder people = People.builder();

        people.name( peoplePostRequestBody.getName() );
        people.gender( peoplePostRequestBody.getGender() );
        people.email( peoplePostRequestBody.getEmail() );
        people.dateBirth( peoplePostRequestBody.getDateBirth() );
        people.naturalness( peoplePostRequestBody.getNaturalness() );
        people.nationality( peoplePostRequestBody.getNationality() );
        people.cpf( peoplePostRequestBody.getCpf() );
        people.createdAt( peoplePostRequestBody.getCreatedAt() );
        people.updatedAt( peoplePostRequestBody.getUpdatedAt() );

        return people.build();
    }

    @Override
    public People toPeople(PeopleDTO peopleDTO) {
        if ( peopleDTO == null ) {
            return null;
        }

        PeopleBuilder people = People.builder();

        people.id( peopleDTO.getId() );
        people.name( peopleDTO.getName() );
        people.gender( peopleDTO.getGender() );
        people.email( peopleDTO.getEmail() );
        people.dateBirth( peopleDTO.getDateBirth() );
        people.naturalness( peopleDTO.getNaturalness() );
        people.nationality( peopleDTO.getNationality() );
        people.cpf( peopleDTO.getCpf() );
        people.createdAt( peopleDTO.getCreatedAt() );
        people.updatedAt( peopleDTO.getUpdatedAt() );

        return people.build();
    }
}
