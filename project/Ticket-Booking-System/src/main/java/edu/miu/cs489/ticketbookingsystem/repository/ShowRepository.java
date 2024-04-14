package edu.miu.cs489.ticketbookingsystem.repository;

import edu.miu.cs489.ticketbookingsystem.domain.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {

    Optional<Show> findShowByShowId(int id);

    Optional<List<Show>> getShowsByShowDateAfter(LocalDate date);

    Optional<List<Show>> getShowsByShowDateBefore(LocalDate date);
}
