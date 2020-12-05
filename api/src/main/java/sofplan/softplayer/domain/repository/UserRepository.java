package sofplan.softplayer.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import sofplan.softplayer.domain.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByUsername(String username);
}
