package edu.miu.cs489.ticketbookingsystem.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;
    private double price;

    @ManyToOne
    @JoinColumn(name = "showId")
//    @JsonBackReference // manage overflow reference back & forth btw bidrirectional entities
    // Handles by using dto & object mapper
    private Show show;

    @ManyToMany(mappedBy = "tickets") //(cascade = { CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<BookingHistory> bookingHistoryList = new ArrayList<>(); // join table with booking history

    public Ticket() {
    }

    public Ticket(int ticketId, double price) {
        this.ticketId = ticketId;
        this.price = price;
    }

    public Ticket(int ticketId, double price, Show show) {
        this.ticketId = ticketId;
        this.price = price;
        this.show = show;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "show=" + show.getShowId() +
                ", price=" + price +
                ", ticketId=" + ticketId +
                '}';
    }
}
