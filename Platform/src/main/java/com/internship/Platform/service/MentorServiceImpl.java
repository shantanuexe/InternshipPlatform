package com.internship.Platform.service;

import org.springframework.stereotype.Service;

import com.internship.Platform.entity.Mentor;
import com.internship.Platform.repository.MentorRepository;

@Service
public class MentorServiceImpl implements MentorService {
    private final MentorRepository mentorRepository;

    public MentorServiceImpl(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    @Override
    public Mentor saveMentor(Mentor mentor) {
        return mentorRepository.save(mentor);
    }
}