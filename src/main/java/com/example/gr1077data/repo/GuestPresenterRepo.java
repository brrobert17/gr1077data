package com.example.gr1077data.repo;

import com.example.gr1077data.model.GuestPresenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestPresenterRepo extends JpaRepository<GuestPresenter, Long> {
}
