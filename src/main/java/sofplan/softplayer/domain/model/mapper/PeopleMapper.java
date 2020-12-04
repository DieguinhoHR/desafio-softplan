package sofplan.softplayer.domain.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sofplan.softplayer.api.v1.requests.PeoplePostRequestBody;
import sofplan.softplayer.api.v1.requests.PeoplePutRequestBody;
import sofplan.softplayer.domain.model.People;

@Mapper(componentModel = "spring") // possibilita fazer injeção de depencia caso precise
public abstract class PeopleMapper {
    public static final PeopleMapper INSTANCE = Mappers.getMapper(PeopleMapper.class);

    public abstract People toPeople(PeoplePostRequestBody peoplePostRequestBody);

    public abstract People toPeople(PeoplePutRequestBody peoplePutRequestBody);
}

