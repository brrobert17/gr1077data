package com.example.gr1077data.repo;

import com.example.gr1077data.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepo extends JpaRepository<Participant, Long> {
    @Query("SELECT p FROM Participant  p WHERE p.firstName LIKE %?1% OR p.lastName LIKE %?1% OR p.email LIKE %?1% OR p.affiliation LIKE %?1% OR p.title LIKE %?1% ")
    List<Participant> findByKeyword(String keyword);
}
