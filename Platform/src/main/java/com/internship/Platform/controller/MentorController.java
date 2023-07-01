package com.internship.Platform.controller;

@RestController
@RequestMapping("/mentors")
public class MentorController {
    private final MentorService mentorService;

    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @PostMapping
    public ResponseEntity<MentorDTO> createMentor(@RequestBody MentorDTO mentorDTO) {
        // Create a Mentor object from the DTO
        Mentor mentor = new Mentor();
        mentor.setFirstName(mentorDTO.getFirstName());
        mentor.setLastName(mentorDTO.getLastName());
        mentor.setEmail(mentorDTO.getEmail());
        mentor.setPhone(mentorDTO.getPhone());
        mentor.setDepartment(mentorDTO.getDepartment());
        mentor.setProjects(mentorDTO.getProjects());

        // Save the mentor in the database
        Mentor savedMentor = mentorService.saveMentor(mentor);

        // Return the saved mentor as DTO
        MentorDTO savedMentorDTO = new MentorDTO();
        savedMentorDTO.setFirstName(savedMentor.getFirstName());
        savedMentorDTO.setLastName(savedMentor.getLastName());
        savedMentorDTO.setEmail(savedMentor.getEmail());
        savedMentorDTO.setPhone(savedMentor.getPhone());
        savedMentorDTO.setDepartment(savedMentor.getDepartment());
        savedMentorDTO.setProjects(savedMentor.getProjects());

        return ResponseEntity.ok(savedMentorDTO);
    }
}