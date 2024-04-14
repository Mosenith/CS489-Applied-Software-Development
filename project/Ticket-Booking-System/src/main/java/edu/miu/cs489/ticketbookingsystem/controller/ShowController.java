package edu.miu.cs489.ticketbookingsystem.controller;

import edu.miu.cs489.ticketbookingsystem.domain.Show;
import edu.miu.cs489.ticketbookingsystem.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("show")
public class ShowController {
    @Autowired
    ShowService showService;

    @GetMapping
    public ResponseEntity<?> getAllShows() {
        List<Show> shows = showService.getAllShows();

        return new ResponseEntity<List<Show>>(shows, HttpStatus.OK);
    }

    @GetMapping("/{showId}")
    public ResponseEntity<?> getShowById(@PathVariable("showId") Integer showId) {
        Show show = showService.getShowById(showId);

        if(show == null) {
            return new ResponseEntity<Show>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Show>(show, HttpStatus.OK);
    }

    @GetMapping("beforeDate/{showDate}")
    public ResponseEntity<?> getShowsBeforeDate(@PathVariable("showDate") LocalDate showDate) {
        List<Show> shows = showService.getShowBeforeDate(showDate);

        if(shows == null) {
            return new ResponseEntity<Show>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Show>>(shows, HttpStatus.OK);
    }

    @GetMapping("afterDate/{showDate}")
    public ResponseEntity<?> getShowsAfterDate(@PathVariable("showDate") LocalDate showDate) {
        List<Show> shows = showService.getShowAfterDate(showDate);

        if(shows == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(shows, HttpStatus.OK);
    }
}