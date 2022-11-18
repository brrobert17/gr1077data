package com.example.gr1077data.repo;

import com.example.gr1077data.model.Researcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResearcherRepo extends JpaRepository<Researcher, Long> {

    @Query("SELECT r FROM Researcher r  WHERE r.firstName LIKE ?1 OR r.lastName like ?1")
    List<Researcher> findResearcherByName (String name);
}
