package edu.miu.cs489.ticketbookingsystem.controller;

import edu.miu.cs489.ticketbookingsystem.domain.FanclubMember;
import edu.miu.cs489.ticketbookingsystem.service.FanclubMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("member")
public class MemberController {
    @Autowired
    FanclubMemberService fanclubMemberService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getFanClubMemberById(@PathVariable int id) {
        FanclubMember member = fanclubMemberService.getFanclubMemberById(id);

        if (member == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping("registeredAfter/{dateRegistered}")
    public ResponseEntity<?> getFanclubMemberRegisteredAfter(@PathVariable("dateRegistered") LocalDate date) {
        List<FanclubMember> members = fanclubMemberService.getFanclubMemberByDateRegisteredAfter(date);

        if (members == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("registeredBefore/{dateRegistered}")
    public ResponseEntity<?> getFanclubMemberRegisteredBefore(@PathVariable("dateRegistered") LocalDate date) {
        List<FanclubMember> members = fanclubMemberService.getFanclubMemberByDateRegisteredBefore(date);

        if (members == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(members, HttpStatus.OK);
    }
}
