package edu.miu.cs489.ticketbookingsystem.controller;

import edu.miu.cs489.ticketbookingsystem.domain.Show;
import edu.miu.cs489.ticketbookingsystem.domain.Ticket;
import edu.miu.cs489.ticketbookingsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping()
    public ResponseEntity<?> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
    }

//    @GetMapping("/{showId}")
//    public ResponseEntity<?> getTicketById(@RequestBody Show show) {
//        List<Ticket> tickets = ticketService.getTicketsByShowId(show);
//
//        if(tickets == null) {
//            return new ResponseEntity<List<Ticket>>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
//    }

    @GetMapping("priceBefore/{price}")
    public ResponseEntity<?> getShowsBeforeDate(@PathVariable("price") Double price) {
        List<Ticket> tickets = ticketService.getTicketsByPriceBefore(price);

        if(tickets == null) {
            return new ResponseEntity<List<Ticket>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Ticket> >(tickets, HttpStatus.OK);
    }

    @GetMapping("priceAfter/{price}")
    public ResponseEntity<?> getShowsAfterDate(@PathVariable("price") Double price) {
        List<Ticket> tickets = ticketService.getTicketsByPriceAfter(price);

        if(tickets == null) {
            return new ResponseEntity<List<Ticket>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Ticket> >(tickets, HttpStatus.OK);
    }
}
