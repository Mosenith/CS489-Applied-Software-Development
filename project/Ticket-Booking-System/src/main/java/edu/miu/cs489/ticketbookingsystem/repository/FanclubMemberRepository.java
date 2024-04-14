package edu.miu.cs489.ticketbookingsystem.repository;

import edu.miu.cs489.ticketbookingsystem.domain.FanclubMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface FanclubMemberRepository extends JpaRepository<FanclubMember, Integer> {

    FanclubMember findFanclubMemberById(Integer id);

    Optional<List<FanclubMember>> findFanclubMemberByDateRegisteredAfter(LocalDate date);

    Optional<List<FanclubMember>> findFanclubMemberByDateRegisteredBefore(LocalDate date);

}
