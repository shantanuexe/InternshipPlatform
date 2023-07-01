package com.internship.Platform.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internship.Platform.dto.CandidateDTO;
import com.internship.Platform.entity.Candidate;
import com.internship.Platform.service.CandidateService;

@RestController
@RequestMapping("/candidates")
public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping
    public ResponseEntity<CandidateDTO> createCandidate(@RequestBody CandidateDTO candidateDTO) {
        // Create a Candidate object from the DTO
        Candidate candidate = new Candidate();
        candidate.setFirstName(candidateDTO.getFirstName());
        candidate.setLastName(candidateDTO.getLastName());
        candidate.setEmail(candidateDTO.getEmail());
        candidate.setPhone(candidateDTO.getPhone());
        candidate.setQualifications(candidateDTO.getQualifications());
        candidate.setProjectPreferences(candidateDTO.getProjectPreferences());

        // Save the candidate in the database
        Candidate savedCandidate = candidateService.saveCandidate(candidate);

        // Return the saved candidate as DTO
        CandidateDTO savedCandidateDTO = new CandidateDTO();
        savedCandidateDTO.setFirstName(savedCandidate.getFirstName());
        savedCandidateDTO.setLastName(savedCandidate.getLastName());
        savedCandidateDTO.setEmail(savedCandidate.getEmail());
        savedCandidateDTO.setPhone(savedCandidate.getPhone());
        savedCandidateDTO.setQualifications(savedCandidate.getQualifications());
        savedCandidateDTO.setProjectPreferences(savedCandidate.getProjectPreferences());

        return ResponseEntity.ok(savedCandidateDTO);
    }
}