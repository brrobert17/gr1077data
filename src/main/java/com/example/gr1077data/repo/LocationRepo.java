package com.example.gr1077data.repo;

import com.example.gr1077data.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepo extends JpaRepository<Location, Long> {
    @Query("SELECT l FROM Location l WHERE l.address LIKE %?1%")
    List<Location> findByKeyword(String keyword);
}
