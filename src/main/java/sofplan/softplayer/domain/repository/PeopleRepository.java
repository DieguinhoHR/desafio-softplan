package sofplan.softplayer.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sofplan.softplayer.domain.model.People;

public interface PeopleRepository extends JpaRepository<People, Long> {
}
