package edu.miu.cs489.ticketbookingsystem.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class BookingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private int firstName;
    private int lastName;
    private String role; // fan club member - if log in as member, otherwise guest

    @ManyToMany // (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "ticket_bookingHistory",
            joinColumns = @JoinColumn(name = "booking_Id", referencedColumnName = "bookingId"),
            inverseJoinColumns = @JoinColumn(name = "ticket_Id", referencedColumnName = "ticketId"))
    private List<Ticket> tickets = new ArrayList<>(); // join table with tickets

    public BookingHistory() {
    }
}
