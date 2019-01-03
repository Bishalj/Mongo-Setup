package com.mongo.setup.mongoqueries.controller;

import com.mongo.setup.mongoqueries.model.Hotel;
import com.mongo.setup.mongoqueries.dao.HotelRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private HotelRepositoryDao hotelRepository;

    public HotelController(HotelRepositoryDao hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/all")
    public List<Hotel> getAll(){
        List<Hotel> hotels = this.hotelRepository.findAll();
        return  hotels;
    }

    @PostMapping("/add")
    public String putHotelDetail(@RequestBody Hotel hotel){
        try {
            this.hotelRepository.insert(hotel);
            return  "Successfull";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @PutMapping("/update")
    public String updateHotelDetail(@RequestBody Hotel hotel){
        try {
            this.hotelRepository.save(hotel);
            return  "Successfull";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/price/{maxPrice}")
    public List<Hotel> getPricePerNight(@PathVariable("maxPrice") int maxPrice){
        try {
           List<Hotel> hotels =  this.hotelRepository.findByPricePerNightLessThan(maxPrice);
            return  hotels;
        }catch (Exception e){
            return null;
        }
    }

}
