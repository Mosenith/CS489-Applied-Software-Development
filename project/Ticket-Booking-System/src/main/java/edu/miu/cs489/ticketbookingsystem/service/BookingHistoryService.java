package edu.miu.cs489.ticketbookingsystem.service;

import edu.miu.cs489.ticketbookingsystem.domain.BookingHistory;
import edu.miu.cs489.ticketbookingsystem.repository.BookingHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingHistoryService {
    @Autowired
    BookingHistoryRepository bookingHistoryRepository;

    public List<BookingHistory> getAllBookingHistory() {
        return bookingHistoryRepository.findAll();
    }

    public BookingHistory getBookingHistoryRepositoryById(Integer id) {
        return bookingHistoryRepository.findBookingHistoriesByBookingId(id).orElse(null);
    }

    public List<BookingHistory> getBookingHistoryByFirstName(String firstName) {
        return bookingHistoryRepository.findBookingHistoriesByFirstName(firstName).orElse(null);
    }

    public List<BookingHistory> getBookingHistoryByLastName(String lastName) {
        return bookingHistoryRepository.findBookingHistoriesByLastName(lastName).orElse(null);
    }

    public List<BookingHistory> getBookingHistoryByRole(String role) {
        return bookingHistoryRepository.findBookingHistoriesByRole(role).orElse(null);
    }
}
