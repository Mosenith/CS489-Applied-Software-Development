package edu.miu.cs489.ticketbookingsystem.service;

import edu.miu.cs489.ticketbookingsystem.domain.Ticket;
import edu.miu.cs489.ticketbookingsystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public List<Ticket> getTicketsByShowId(Integer showId) {
        Optional<List<Ticket>> ticket = ticketRepository.findTicketByShowId(showId);
        return ticket.orElse(null);
    }

    public List<Ticket> getTicketsByPriceAfter(Double price) {
        Optional<List<Ticket>> ticket = ticketRepository.findTicketByPriceAfter(price);
        return ticket.orElse(null);
    }

    public List<Ticket> getTicketsByPriceBefore(Double price) {
        Optional<List<Ticket>> ticket = ticketRepository.findTicketByPriceBefore(price);
        return ticket.orElse(null);
    }
}
