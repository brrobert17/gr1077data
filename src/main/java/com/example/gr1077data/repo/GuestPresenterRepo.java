package com.example.gr1077data.repo;

import com.example.gr1077data.model.GuestPresenter;
import com.example.gr1077data.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestPresenterRepo extends JpaRepository<GuestPresenter, Long> {
    @Query("SELECT g FROM GuestPresenter  g WHERE g.firstName LIKE %?1% OR g.lastName LIKE %?1% OR g.email LIKE %?1% OR g.telephone LIKE %?1% OR g.title LIKE %?1% ")
    List<GuestPresenter> findByKeyword(String keyword);
}
