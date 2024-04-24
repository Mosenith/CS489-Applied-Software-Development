package food.repository;

import food.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    // used to look up User by their Username
    User findUserByUsername(String username);

    // Method to save the token for a specific user
//    void saveTokenByUsername(String username, String token);

    // Method to find a user by their token
    User findUserByToken(String token);
}
