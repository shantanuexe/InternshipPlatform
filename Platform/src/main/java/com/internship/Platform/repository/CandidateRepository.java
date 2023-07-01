package com.internship.Platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internship.Platform.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    // Add custom query methods if needed
}