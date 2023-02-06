package com.example.gr1077data.repo;

import com.example.gr1077data.model.OtherPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherPageRepo extends JpaRepository<OtherPage, Long> {

}