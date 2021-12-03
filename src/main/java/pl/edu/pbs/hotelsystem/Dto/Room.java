package pl.edu.pbs.hotelsystem.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Room  {
    @Id
    @GeneratedValue
    private Long id;
    private Integer roomNumber;
    private Integer capacity;
    private Integer ratePerDay;
    private Boolean isAvaible;

    public Room( Integer capacity, Integer ratePerDay,Integer roomNumber) {

        this.capacity = capacity;

        this.ratePerDay = ratePerDay;
        this.roomNumber = roomNumber;
    }
}