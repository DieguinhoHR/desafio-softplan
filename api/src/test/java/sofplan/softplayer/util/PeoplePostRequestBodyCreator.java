package sofplan.softplayer.util;

import sofplan.softplayer.api.v1.dto.PeopleNewDTO;

public class PeoplePostRequestBodyCreator {
    public static PeopleNewDTO createPeoplePostRequestBody() {
        return PeopleNewDTO.builder()
                .name(PeopleCreator.createPeopleToBeSaved().getName())
                .build();
    }
}
