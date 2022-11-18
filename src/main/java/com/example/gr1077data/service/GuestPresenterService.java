package com.example.gr1077data.service;

import com.example.gr1077data.model.GuestPresenter;
import com.example.gr1077data.model.Participant;
import com.example.gr1077data.repo.GuestPresenterRepo;
import com.example.gr1077data.repo.ParticipantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class GuestPresenterService {
    private final GuestPresenterRepo guestPresenterRepo;

    @Autowired
    public GuestPresenterService(GuestPresenterRepo guestPresenterRepo) {
        this.guestPresenterRepo = guestPresenterRepo;
    }


    //get all customers
    public List<GuestPresenter> getAllGuestPresenter() {
        List<GuestPresenter> guestPresenterList = guestPresenterRepo.findAll();
        return guestPresenterList;
    }


    //get customer by id
    public GuestPresenter getGuestPresenterById(Long id) {
        return guestPresenterRepo.findById(id).orElse(null);
    }

    public GuestPresenter createGuestPresenter(GuestPresenter guestPresenter) {
        return guestPresenterRepo.save(guestPresenter);
    }

    public GuestPresenter updateGuestPresenter(Long id, GuestPresenter newguestPresenter){
        if(guestPresenterRepo.findById(id).isEmpty()){
            return null;
        }
        return guestPresenterRepo.save(newguestPresenter);
    }


    public void deleteGuestPresenter(Long id)  {
        guestPresenterRepo.deleteById(id);
    }
    //find customer by keyword
    public List <GuestPresenter> findByKeyword(String keyword) {
        if (keyword != null) {
            return guestPresenterRepo.findByKeyword(keyword);
        }
        return guestPresenterRepo.findAll();
    }
}
