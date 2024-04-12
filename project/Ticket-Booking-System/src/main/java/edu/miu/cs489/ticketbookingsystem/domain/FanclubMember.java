package edu.miu.cs489.ticketbookingsystem.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class FanclubMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String password; // distinguish guest & member with same firstName & lastName
    private String phone;
    private String email;
    private LocalDate dateRegistered;

    @ManyToMany // (mappedBy = "showId") // (cascade = { CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "membership_show",
            joinColumns = @JoinColumn(name = "member_Id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "show_Id", referencedColumnName = "showId"))
    private List<Show> shows = new ArrayList<>(); // Member can view all the shows

    @OneToMany
    @JoinColumn(name = "bookingId")
    private List<BookingHistory> historyList = new ArrayList<>();

    public FanclubMember() {
    }

    public FanclubMember(int id, String firstName, String lastName, String password, String phone, String email, LocalDate dateRegistered) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.dateRegistered = dateRegistered;
    }

    @Override
    public String toString() {
        return "FanclubMember{" +
                "dateRegistered=" + dateRegistered +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                '}';
    }
}
