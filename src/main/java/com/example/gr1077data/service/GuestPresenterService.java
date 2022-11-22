package com.example.gr1077data.service;

import com.example.gr1077data.model.GuestPresenter;
import com.example.gr1077data.model.Participant;
import com.example.gr1077data.repo.GuestPresenterRepo;
import com.example.gr1077data.repo.ParticipantRepo;
import com.example.gr1077data.service.exception.GuestPresenterNotFoundException;
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
    public List<GuestPresenter> getAllGuestPresenter() throws GuestPresenterNotFoundException {
        return guestPresenterRepo.findAll();
    }

    //get customer by id
    public GuestPresenter getGuestPresenterById(Long id) throws GuestPresenterNotFoundException {
        return guestPresenterRepo.findById(id).orElse(null);
    }
    //if image is not used by any other external researcher, then add it to the new external researcher and save it

    public GuestPresenter createGuestPresenter(GuestPresenter guestPresenter) throws GuestPresenterNotFoundException {
        //assine image to image if it is not used by any other external researcher



        return guestPresenterRepo.save(guestPresenter);
    }

    public GuestPresenter updateGuestPresenter(Long id, GuestPresenter newGuestPresenter) throws GuestPresenterNotFoundException {
        if (guestPresenterRepo.findById(id).isEmpty()) {
            return null;
        }
        return guestPresenterRepo.save(newGuestPresenter);
    }


    public void deleteGuestPresenter(Long id) throws GuestPresenterNotFoundException {

        guestPresenterRepo.deleteById(id);
    }

    //find customer by keyword
    public List<GuestPresenter> findByKeyword(String keyword) throws GuestPresenterNotFoundException {
        if (keyword != null) {
            return guestPresenterRepo.findByKeyword(keyword);
        }
        return guestPresenterRepo.findAll();
    }
    //cheak image and blogpodt in gusetPresenter

}
