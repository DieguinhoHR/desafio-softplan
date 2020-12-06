package sofplan.softplayer.util;

import sofplan.softplayer.api.v1.dto.PeopleDTO;

public class PeoplePutRequestBodyCreator {
    public static PeopleDTO createPeoplePutRequestBody() {
        return PeopleDTO.builder()
                .id(PeopleCreator.createValidUpdatedPeople().getId())
                .name(PeopleCreator.createPeopleToBeSaved().getName())
                .build();
    }
}
