package sofplan.softplayer.domain.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sofplan.softplayer.api.v1.requests.PeoplePostRequestBody;
import sofplan.softplayer.api.v1.requests.PeoplePutRequestBody;
import sofplan.softplayer.domain.model.People;

@Mapper(componentModel = "spring")
public interface PeopleMapper {
    public static final PeopleMapper INSTANCE = Mappers.getMapper(PeopleMapper.class);
    @Mapping(source = "name", target = "name")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "dateBirth", target = "dateBirth")
    @Mapping(source = "naturalness", target = "naturalness")
    @Mapping(source = "nationality", target = "nationality")
    @Mapping(source = "cpf", target = "cpf")
    public abstract People toPeople(PeoplePostRequestBody peoplePostRequestBody);
    public abstract People toPeople(PeoplePutRequestBody peoplePutRequestBody);
}


