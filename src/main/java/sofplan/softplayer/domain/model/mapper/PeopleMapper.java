package sofplan.softplayer.domain.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sofplan.softplayer.api.v1.dto.PeopleDTO;
import sofplan.softplayer.api.v1.dto.PeopleNewDTO;
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
    @Mapping(source = "password", target = "password")
    public abstract People toPeople(PeopleNewDTO peoplePostRequestBody);
    public abstract People toPeople(PeopleDTO peopleDTO);
}


