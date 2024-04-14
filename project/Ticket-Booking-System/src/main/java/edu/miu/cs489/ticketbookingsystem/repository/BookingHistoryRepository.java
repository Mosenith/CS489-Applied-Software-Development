package edu.miu.cs489.ticketbookingsystem.repository;

import edu.miu.cs489.ticketbookingsystem.domain.BookingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingHistoryRepository extends JpaRepository<BookingHistory,Integer> {

    Optional<BookingHistory> findBookingHistoriesByBookingId(Integer bookingId);

    Optional<List<BookingHistory>> findBookingHistoriesByFirstName(String fname);

    Optional<List<BookingHistory>> findBookingHistoriesByLastName(String lname);

    Optional<List<BookingHistory>> findBookingHistoriesByRole(String role);

}
