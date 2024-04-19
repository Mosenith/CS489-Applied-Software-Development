package food.repository;

import food.domain.User;
import jdk.jfr.Registered;
import org.springframework.data.repository.CrudRepository;

@Registered
public interface UserRepository extends CrudRepository<User, Long> {
    // used to look up User by their Username
    User findUserByUsername(String username);
}
