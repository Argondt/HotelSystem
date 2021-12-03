package pl.edu.pbs.hotelsystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pbs.hotelsystem.Dto.Reservation;
import pl.edu.pbs.hotelsystem.Dto.Room;
import pl.edu.pbs.hotelsystem.Dto.User;
import pl.edu.pbs.hotelsystem.Repository.ReveservationRepository;
import pl.edu.pbs.hotelsystem.Repository.RoomRepository;
import pl.edu.pbs.hotelsystem.Repository.UserRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitService {
    @Autowired
    ReveservationRepository reservationRepo;
    @Autowired
    RoomRepository roomRepo;
    @Autowired
    UserRepository userRepo;

    @PostConstruct
    private void init() {
        Room room1 = new Room(1, 306, 1);
        Room room2 = new Room(1, 313, 2);
        Room room3 = new Room(1, 234, 3);
        Room room4 = new Room(2, 170, 4);
        Room room5 = new Room(1, 146, 5);
        Room room6 = new Room(3, 199, 6);
        Room room7 = new Room(3, 309, 7);
        Room room8 = new Room(2, 358, 8);
        Room room9 = new Room(3, 248, 9);
        Room room10 = new Room(3, 15, 10);
        Room room11 = new Room(3, 171, 11);
        Room room12 = new Room(3, 198, 12);
        Room room13 = new Room(1, 295, 13);
        Room room14 = new Room(2, 295, 14);
        Room room15 = new Room(3, 261, 15);
        roomRepo.save(room1);
        roomRepo.save(room2);
        roomRepo.save(room3);
        roomRepo.save(room4);
        roomRepo.save(room5);
        roomRepo.save(room6);
        roomRepo.save(room7);
        roomRepo.save(room8);
        roomRepo.save(room9);
        roomRepo.save(room10);
        roomRepo.save(room11);
        roomRepo.save(room12);
        roomRepo.save(room13);
        roomRepo.save(room14);
        roomRepo.save(room15);
        User user = new User("Konrad", "Kowalski");
        User user1 = new User("Denis", "Kamiński");
        User user2 = new User("Mateusz ", "Głowacka");
        userRepo.save(user);
        userRepo.save(user1);
        userRepo.save(user2);
        List<Room> roomList1 = new ArrayList<>();
        roomList1.add(room4);
        roomList1.add(room14);
        roomList1.add(room15);
        List<Room> roomList2 = new ArrayList<>();
        roomList2.add(room8);

        List<Room> roomList3 = new ArrayList<>();
        roomList3.add(room1);

        reservationRepo.save(new Reservation(user, roomList1, 7, LocalDate.of(2021, 12, 14), LocalDate.of(2021, 6, 28)));
        reservationRepo.save(new Reservation(user1, roomList2, 2, LocalDate.of(2021, 12, 25), LocalDate.of(2021, 6, 28)));
        reservationRepo.save(new Reservation(user2, roomList3, 1, LocalDate.of(2021, 11, 29), LocalDate.of(2021, 7, 12)));

    }
}
