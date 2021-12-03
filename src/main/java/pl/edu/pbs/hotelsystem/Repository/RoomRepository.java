package pl.edu.pbs.hotelsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pbs.hotelsystem.Dto.Room;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
    Room findAllByRatePerDay(Long number);
    Room findAllByCapacity(Long capacity);

}