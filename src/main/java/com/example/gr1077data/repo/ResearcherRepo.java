package com.example.gr1077data.repo;

import com.example.gr1077data.model.Researcher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ResearcherRepo extends JpaRepository<Researcher, Long> {

    @Query("SELECT r FROM Researcher r  WHERE r.firstName " +
            "LIKE %?1% OR r.lastName like %?1%")
    List<Researcher> findResearcherByName(String name);

}
