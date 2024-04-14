package edu.miu.cs489.ticketbookingsystem.service;

import edu.miu.cs489.ticketbookingsystem.domain.Show;
import edu.miu.cs489.ticketbookingsystem.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepo;

    public List<Show> getAllShows() {
        return showRepo.findAll();
    }

    public Show getShowById(int id) {
        Optional<Show> show = showRepo.findShowByShowId(id);

        return show.orElse(null);

    }

    public List<Show> getShowBeforeDate(LocalDate date) {
        Optional<List<Show>> shows = showRepo.getShowsByShowDateBefore(date);

        return shows.orElse(null);
    }

    public List<Show> getShowAfterDate(LocalDate date) {
        Optional<List<Show>> shows = showRepo.getShowsByShowDateAfter(date);

        return shows.orElse(null);
    }
}
