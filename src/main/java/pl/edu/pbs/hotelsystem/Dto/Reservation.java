package pl.edu.pbs.hotelsystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue()
    private Long id;
    @ManyToOne
    private User user;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Room> room;
    private Integer numberOfPeople;
    private LocalDate dateOfArrival;
    private LocalDate departureDate;


    public Reservation(User user, List<Room> room, Integer numberOfPeople, LocalDate dateOfArrival, LocalDate departureDate) {
        this.user = user;
        this.room = room;
        this.numberOfPeople = numberOfPeople;
        this.dateOfArrival = dateOfArrival;
        this.departureDate = departureDate;
    }
}