package edu.miu.cs489.ticketbookingsystem.repository;

import edu.miu.cs489.ticketbookingsystem.domain.FanclubMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FanclubMemberRepository extends JpaRepository<FanclubMember, Integer> {
}
