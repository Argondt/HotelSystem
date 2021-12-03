package pl.edu.pbs.hotelsystem.Repository;

import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pbs.hotelsystem.Dto.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
