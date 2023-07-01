package com.internship.Platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internship.Platform.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Add custom query methods if needed
}
