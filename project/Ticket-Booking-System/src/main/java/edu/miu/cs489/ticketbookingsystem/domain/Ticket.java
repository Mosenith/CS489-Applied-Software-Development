package edu.miu.cs489.ticketbookingsystem.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.ArrayList;

@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;
    private double price;

    @ManyToOne
    @JoinColumn(name = "showId")
    private Show showId;

    @ManyToMany(mappedBy = "tickets") //(cascade = { CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<BookingHistory> bookingHistoryList = new ArrayList<>(); // join table with booking history

    public Ticket() {
    }

    public Ticket(int ticketId, double price, Show showId) {
        this.ticketId = ticketId;
        this.price = price;
        this.showId = showId;
    }
}
