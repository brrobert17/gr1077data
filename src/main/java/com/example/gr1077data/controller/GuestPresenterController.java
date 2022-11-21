package com.example.gr1077data.controller;

import com.example.gr1077data.model.GuestPresenter;
import com.example.gr1077data.model.Participant;
import com.example.gr1077data.service.GuestPresenterService;
import com.example.gr1077data.service.ParticipantService;
import com.example.gr1077data.service.exception.GuestPresenterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GuestPresenterController {
    private final GuestPresenterService guestPresenterService;
    @Autowired
    public GuestPresenterController(GuestPresenterService guestPresenterService) {
        this.guestPresenterService = guestPresenterService;
    }
    //return all customers
    @GetMapping("/guestPresenters")
    public ResponseEntity<List<GuestPresenter>> getAllGuestPresenters() throws GuestPresenterNotFoundException {
        List<GuestPresenter> guestPresenters = guestPresenterService.getAllGuestPresenter();
        return new ResponseEntity<>(guestPresenters, HttpStatus.OK);
    }



    //return customer by id
    @GetMapping("/guestPresenters/{id}")
    public ResponseEntity<GuestPresenter> getGuestPresenterById(@PathVariable("id") Long id) throws GuestPresenterNotFoundException {
        GuestPresenter guestparticipant = guestPresenterService.getGuestPresenterById(id);
        return new ResponseEntity<>(guestparticipant, HttpStatus.OK);
    }

    //Create guestPresenter
    @PostMapping("/guestPresenters")
    public ResponseEntity<GuestPresenter> createGuestPresenter(@RequestBody GuestPresenter newGuestPresenter) throws GuestPresenterNotFoundException {
        GuestPresenter guestPresenter = guestPresenterService.createGuestPresenter(newGuestPresenter);
        return new ResponseEntity<>(guestPresenter, HttpStatus.CREATED);
    }

    @PutMapping("/guestPresenters/{id}")
    public ResponseEntity<GuestPresenter> updateGuestPresenter(@RequestBody GuestPresenter newGuestPresenter, @PathVariable("id")Long id) throws GuestPresenterNotFoundException {
        if(id==null || id<=0 || newGuestPresenter==null || newGuestPresenter.getId()==null ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            GuestPresenter guestPresenter = guestPresenterService.updateGuestPresenter(id, newGuestPresenter);
            return new ResponseEntity<>(guestPresenter, HttpStatus.OK);
        }
    }

    @DeleteMapping("/guestPresenters/{id}")
    public ResponseEntity<?> deleteGuestPresenter(@PathVariable("id") Long id) throws GuestPresenterNotFoundException {
        guestPresenterService.deleteGuestPresenter(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //find by keyword and put it in list of customers
    @GetMapping(value = "/guestPresenters",params = "keyword")
    public List<GuestPresenter> findByKeyword(@RequestParam(name="keyword") String keyword) throws GuestPresenterNotFoundException {
        return guestPresenterService.findByKeyword(keyword);
    }

}


