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

    @ManyToMany(cascade = { CascadeType.PERSIST,
            CascadeType.MERGE},
            fetch = FetchType.EAGER)
    private List<Show> shows = new ArrayList<>(); // Member can view all the shows

    @OneToMany
    @JoinColumn(name = "bookingId")
    private List<BookingHistory> historyList = new ArrayList<>();

    public FanclubMember() {
    }
}
