package sofplan.softplayer.domain.model.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sofplan.softplayer.api.v1.dto.PeopleDTO;
import sofplan.softplayer.api.v1.dto.PeopleNewDTO;
import sofplan.softplayer.domain.model.People;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-05T23:49:46-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class PeopleMapperImpl implements PeopleMapper {

    @Override
    public People toPeople(PeopleNewDTO peoplePostRequestBody) {
        if ( peoplePostRequestBody == null ) {
            return null;
        }

        People people = new People();

        return people;
    }

    @Override
    public People toPeople(PeopleDTO peopleDTO) {
        if ( peopleDTO == null ) {
            return null;
        }

        People people = new People();

        return people;
    }
}
