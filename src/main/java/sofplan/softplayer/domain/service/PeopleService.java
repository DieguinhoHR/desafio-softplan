package sofplan.softplayer.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sofplan.softplayer.api.v1.requests.PeoplePostRequestBody;
import sofplan.softplayer.api.v1.requests.PeoplePutRequestBody;
import sofplan.softplayer.domain.model.People;
import sofplan.softplayer.domain.model.mapper.PeopleMapper;
import sofplan.softplayer.domain.repository.PeopleRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class PeopleService {
    private final PeopleRepository peopleRepository;

    public List<People> listAll() {
        return peopleRepository.findAll();
    }

    public People findById(Long id) {
        return peopleRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada"));
    }

    @Transactional
    public People save(PeoplePostRequestBody peoplePostRequestBody) {
        return peopleRepository.save(PeopleMapper.INSTANCE.toPeople(peoplePostRequestBody));
    }

    public void update(PeoplePutRequestBody peoplePutRequestBody) {
        People savedPeople = findById(peoplePutRequestBody.getId());
        People people = PeopleMapper.INSTANCE.toPeople(peoplePutRequestBody);
        people.setId(savedPeople.getId());
        peopleRepository.save(people);
    }

    public void delete(long id) {
        peopleRepository.delete(findById(id));
    }
}
