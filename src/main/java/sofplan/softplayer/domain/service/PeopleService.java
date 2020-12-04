package sofplan.softplayer.domain.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import sofplan.softplayer.domain.model.People;
import sofplan.softplayer.domain.repository.PeopleRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PeopleService {
    private final PeopleRepository peopleRepository;

    public List<People> listAll() {
        return peopleRepository.findAll();
    }

    public Optional<People> findById(Long id) {
        return peopleRepository.findById(id);
    }
}
