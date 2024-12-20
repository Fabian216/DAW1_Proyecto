package proyecto.backend.repository;

import org.springframework.data.repository.CrudRepository;
import proyecto.backend.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
