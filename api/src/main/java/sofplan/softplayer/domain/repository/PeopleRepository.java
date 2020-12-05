package sofplan.softplayer.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sofplan.softplayer.domain.model.People;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Long> {
    List<People> findByName(String name);
}
