package In.NIT.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import In.NIT.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
