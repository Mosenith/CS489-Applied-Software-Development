package edu.miu.cs489.ticketbookingsystem.controller;


import edu.miu.cs489.ticketbookingsystem.domain.BookingHistory;
import edu.miu.cs489.ticketbookingsystem.domain.Show;
import edu.miu.cs489.ticketbookingsystem.service.BookingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("history")
public class BookingHistoryController {
    @Autowired
    BookingHistoryService bookingHistoryService;

    @GetMapping
    public ResponseEntity<?> getAllBookingHistories() {
        List<BookingHistory> histories = bookingHistoryService.getAllBookingHistory();

        return new ResponseEntity<>(histories, HttpStatus.OK);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<?> getBookingHistoryById(@PathVariable("bookingId") Integer bookingId) {
        BookingHistory history = bookingHistoryService.getBookingHistoryById(bookingId);

        if(history == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(history, HttpStatus.OK);
    }

    @GetMapping("/{role}")
    public ResponseEntity<?> getBookingHistoryByRole(@PathVariable("role") String role) {
        List<BookingHistory> histories = bookingHistoryService.getBookingHistoryByRole(role);

        if(histories == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(histories, HttpStatus.OK);
    }
}
