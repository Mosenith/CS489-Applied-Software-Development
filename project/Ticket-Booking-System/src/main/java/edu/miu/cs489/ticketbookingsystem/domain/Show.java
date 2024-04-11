package edu.miu.cs489.ticketbookingsystem.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Concert_Show")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showId;
    private LocalDate showDate;

    @OneToMany(mappedBy = "showId")
    private Set<Ticket> ticketSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "membership_show",
            joinColumns = @JoinColumn(name = "show_Id", referencedColumnName = "showId"),
            inverseJoinColumns = @JoinColumn(name = "fanclubMember_Id", referencedColumnName = "id"))
    private List<FanclubMember> members = new ArrayList<>();

    public Show() {
    }

    public Show(int showId, LocalDate showDate) {
        this.showId = showId;
        this.showDate = showDate;
    }
}
