package edu.miu.cs489.ticketbookingsystem;

import edu.miu.cs489.ticketbookingsystem.domain.BookingHistory;
import edu.miu.cs489.ticketbookingsystem.domain.FanclubMember;
import edu.miu.cs489.ticketbookingsystem.domain.Show;
import edu.miu.cs489.ticketbookingsystem.domain.Ticket;
import edu.miu.cs489.ticketbookingsystem.repository.BookingHistoryRepository;
import edu.miu.cs489.ticketbookingsystem.repository.FanclubMemberRepository;
import edu.miu.cs489.ticketbookingsystem.repository.ShowRepository;
import edu.miu.cs489.ticketbookingsystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class TicketBookingSystemApplication implements CommandLineRunner {

    @Autowired
    private FanclubMemberRepository fanclubMemberRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private BookingHistoryRepository bookingHistoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(TicketBookingSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        populateFanclubMember();
//        populateShow();
        FanclubMember f1 = fanclubMemberRepository.findById(1).get();
        FanclubMember f2 = fanclubMemberRepository.findById(3).get();

        // show 1
        Ticket ticket1 = new Ticket(1,50,showRepository.findById(1).get());
        Ticket ticket2 = new Ticket(1,50,showRepository.findById(1).get());
        Ticket ticket3 = new Ticket(1,50,showRepository.findById(1).get());
        List<Ticket> l1 = new ArrayList<>();
        l1.add(ticket1);
        l1.add(ticket2);
        l1.add(ticket3);

        // show 2
        Ticket ticket4 = new Ticket(1,50,showRepository.findById(2).get());
        Ticket ticket5 = new Ticket(1,50,showRepository.findById(2).get());
        List<Ticket> l2 = new ArrayList<>();
        l2.add(ticket4);
        l2.add(ticket5);

        // f1 book 3 tickets of show1
        BookingHistory bh1 = new BookingHistory(1, f1.getFirstName(), f2.getLastName(),
                "member", l1);
        List<BookingHistory> ls = new ArrayList<>();
        ls.add(bh1);
        f1.setHistoryList(ls);

        // f2 book 2 tickets of show2
        BookingHistory bh2 = new BookingHistory(2, f2.getFirstName(), f2.getLastName(),
                "member", l2);
        List<BookingHistory> ls2 = new ArrayList<>();
        ls2.add(bh2);
        f2.setHistoryList(ls2);

        bookingHistoryRepository.saveAndFlush(bh1);
        bookingHistoryRepository.saveAndFlush(bh2);

//        showRepository.deleteAll();
    }

    // populate FanclubMember data
    private void populateFanclubMember() {
        FanclubMember m1 = new FanclubMember(1, "John", "Smith", "password1", "1234567891", "john.smith@example.com", LocalDate.now());
        FanclubMember m2 = new FanclubMember(2, "Emily", "Johnson", "password2", "1234567892", "emily.johnson@example.com", LocalDate.now());
        FanclubMember m3 = new FanclubMember(3, "Michael", "Williams", "password3", "1234567893", "michael.williams@example.com", LocalDate.now());
        FanclubMember m4 = new FanclubMember(4, "Sophia", "Brown", "password4", "1234567894", "sophia.brown@example.com", LocalDate.now());
        FanclubMember m5 = new FanclubMember(5, "William", "Jones", "password5", "1234567895", "william.jones@example.com", LocalDate.now());

        fanclubMemberRepository.saveAndFlush(m1);
        fanclubMemberRepository.saveAndFlush(m2);
        fanclubMemberRepository.saveAndFlush(m3);
        fanclubMemberRepository.saveAndFlush(m4);
        fanclubMemberRepository.saveAndFlush(m5);

        for(FanclubMember f : fanclubMemberRepository.findAll()) {
            System.out.println(f.toString());
        }
    }

    // populate Show data
    private void populateShow() {
//        LocalDate nextMonth = LocalDate.now().plusMonths(1);
//
//        Show s1 = new Show(1, nextMonth.withDayOfMonth(4));
//        Show s2 = new Show(2, nextMonth.withDayOfMonth(11));
//        Show s3 = new Show(3, nextMonth.withDayOfMonth(18));

        // Creating a show
        Show show1 = new Show();
        show1.setShowDate(LocalDate.of(2024, 4, 20));
        List<Ticket> ticketsForShow1 = new ArrayList<>();

        // Creating another show
        Show show2 = new Show();
        show2.setShowDate(LocalDate.of(2024, 4, 21));
        List<Ticket> ticketsForShow2 = new ArrayList<>();

        // Creating tickets for show1
        Ticket ticket1 = new Ticket();
        ticket1.setPrice(50.0);
        ticket1.setShow(show1);
        ticketsForShow1.add(ticket1);

        Ticket ticket2 = new Ticket();
        ticket2.setPrice(50.0);
        ticket2.setShow(show1);
        ticketsForShow1.add(ticket2);

        // Creating tickets for show2
        Ticket ticket3 = new Ticket();
        ticket3.setPrice(50.0);
        ticket3.setShow(show2);
        ticketsForShow2.add(ticket3);

        Ticket ticket4 = new Ticket();
        ticket4.setPrice(50.0);
        ticket4.setShow(show2);
        ticketsForShow2.add(ticket4);

        Ticket ticket5 = new Ticket();
        ticket5.setPrice(50.0);
        ticket5.setShow(show2);
        ticketsForShow2.add(ticket5);

        // Save shows first
        showRepository.saveAndFlush(show1);
        showRepository.saveAndFlush(show2);

        // Save tickets after shows have been saved
        ticketRepository.save(ticket1);
        ticketRepository.save(ticket2);
        ticketRepository.save(ticket3);
        ticketRepository.save(ticket4);
        ticketRepository.save(ticket5);

        // Update show with tickets
        show1.setTicketSet(ticketsForShow1);
        show2.setTicketSet(ticketsForShow2);

        // Save shows again to update the association
        showRepository.saveAndFlush(show1);
        showRepository.saveAndFlush(show2);

        for(Show s : showRepository.findAll()) {
            System.out.println(s.toString());
        }
    }

    // generate ticket info
    private Set<Ticket> generateTicketsForShow(Show show) {
        Set<Ticket> set = new HashSet<>();
        for (int i = 1; i <= 5; i++) {
            Ticket ticket = new Ticket();
            ticket.setTicketId(i);
            ticket.setPrice(100);
            ticket.setShow(show);
            set.add(ticket);
            ticketRepository.saveAndFlush(ticket);
        }

        return set;
    }
}
