package com.internship.Platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.internship.Platform.entity.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
    // Add custom query methods if needed
}