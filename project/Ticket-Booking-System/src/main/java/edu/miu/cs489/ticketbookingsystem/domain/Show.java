package edu.miu.cs489.ticketbookingsystem.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name = "Concert_Show")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showId;
    private LocalDate showDate;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
//    @JsonManagedReference // manage overflow reference back & forth btw bidrirectional entities
    private List<Ticket> ticketSet = new ArrayList<>();

    @ManyToMany(mappedBy = "shows") // (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "membership_show",
//            joinColumns = @JoinColumn(name = "show_Id", referencedColumnName = "showId"),
//            inverseJoinColumns = @JoinColumn(name = "fanclubMember_Id", referencedColumnName = "id"))
    private List<FanclubMember> members = new ArrayList<>();

    public Show() {
    }

    public Show(int showId, LocalDate showDate) {
        this.showId = showId;
        this.showDate = showDate;
    }

    public boolean isSoldOut() {
        return ticketSet.size() <= 5; // limit each show ticket to maximum 5
    }

    @Override
    public String toString() {
        return "Show{" +
                "showDate=" + showDate +
                ", showId=" + showId +
                '}';
    }
}
