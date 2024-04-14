package edu.miu.cs489.ticketbookingsystem.service;

import edu.miu.cs489.ticketbookingsystem.domain.FanclubMember;
import edu.miu.cs489.ticketbookingsystem.repository.FanclubMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FanclubMemberService {
    @Autowired
    FanclubMemberRepository fanclubMemberRepository;

    public FanclubMember getFanclubMemberById(int id) {
        return fanclubMemberRepository.findFanclubMemberById(id);
    }

    public List<FanclubMember> getFanclubMemberByDateRegisteredAfter(LocalDate date) {
        return fanclubMemberRepository.findFanclubMemberByDateRegisteredAfter(date).orElse(null);
    }

    public List<FanclubMember> getFanclubMemberByDateRegisteredBefore(LocalDate date) {
        return fanclubMemberRepository.findFanclubMemberByDateRegisteredBefore(date).orElse(null);
    }
}
