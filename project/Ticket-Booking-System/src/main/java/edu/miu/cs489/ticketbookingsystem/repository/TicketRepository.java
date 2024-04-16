package edu.miu.cs489.ticketbookingsystem.repository;

import edu.miu.cs489.ticketbookingsystem.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {

    Optional<Ticket> findTicketByTicketId(Integer ticketId);

//    Optional<List<Ticket>> findTicketByShow(Integer showId);

    // More expensive than given price
    Optional<List<Ticket>> findTicketByPriceAfter(Double price);

    // Cheaper than given price
    Optional<List<Ticket>> findTicketByPriceBefore(Double price);
}
