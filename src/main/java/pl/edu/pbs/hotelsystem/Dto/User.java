package pl.edu.pbs.hotelsystem.Dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User{
    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String user;
    private String password;
    private String role;


    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

}