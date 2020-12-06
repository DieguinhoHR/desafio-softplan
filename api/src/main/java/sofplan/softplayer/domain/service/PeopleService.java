package sofplan.softplayer.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sofplan.softplayer.api.v1.dto.PeopleDTO;
import sofplan.softplayer.api.v1.dto.PeopleNewDTO;
import sofplan.softplayer.domain.exception.PeopleNotFoundException;
import sofplan.softplayer.domain.model.People;
import sofplan.softplayer.domain.model.mapper.PeopleMapper;
import sofplan.softplayer.domain.repository.PeopleRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PeopleService {
    private final PeopleRepository peopleRepository;

    public Page<People> listAll(Pageable pageable) {
        return peopleRepository.findAll(pageable);
    }

    public List<People> findByName(String name) {
        return peopleRepository.findByName(name);
    }

    public People findById(long id) {
        return peopleRepository.findById(id)
                .orElseThrow(() -> new PeopleNotFoundException("Pessoa não encontrada"));
    }

    @Transactional
    public People save(PeopleNewDTO peoplePostRequestBody) {
        return peopleRepository.save(PeopleMapper.INSTANCE.toPeople(peoplePostRequestBody));
    }

    public void update(PeopleDTO peopleDTO) {
        People savedPeople = findById(peopleDTO.getId());
        People people = PeopleMapper.INSTANCE.toPeople(peopleDTO);
        people.setId(savedPeople.getId());
        peopleRepository.save(people);
    }

    @Transactional
    public void delete(long id) {
        peopleRepository.delete(findById(id));
    }
}
