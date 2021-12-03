package pl.edu.pbs.hotelsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pbs.hotelsystem.Dto.Reservation;
import pl.edu.pbs.hotelsystem.Dto.Room;

import java.util.List;

@Repository
public interface ReveservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByRoom(Room room);
}
