package com.internship.Platform.service;

import org.springframework.stereotype.Service;

import com.internship.Platform.entity.Candidate;
import com.internship.Platform.repository.CandidateRepository;

@Service
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository candidateRepository;

    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }
}