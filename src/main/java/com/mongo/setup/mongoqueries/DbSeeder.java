package com.mongo.setup.mongoqueries;

import com.mongo.setup.mongoqueries.model.Address;
import com.mongo.setup.mongoqueries.model.Hotel;
import com.mongo.setup.mongoqueries.model.Review;
import com.mongo.setup.mongoqueries.service.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder  implements CommandLineRunner {

    private HotelRepository hotelRepository;

    public DbSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Hotel itc = new Hotel(
                "ITC SONAR BANGLA",
                22000,
                new Address("Kolkata","India"),
                Arrays.asList(
                        new Review("Bishal",9, true),
                        new Review("Sagar",9,false)
                )
        );

        Hotel ibis = new Hotel(
                "IBIS",
                2000,
                new Address("GOA","India"),
                Arrays.asList(
                        new Review("Teddy",8, true),
                        new Review("John",9,false)
                )
        );

        Hotel novotel = new Hotel(
                "NOVOTEL",
                22000,
                new Address("Paris","Italy"),
                Arrays.asList(
                        new Review("Bishal",9, true),
                        new Review("Sagar",9,false)
                )
        );

        Hotel hayatt = new Hotel(
                "HAYATT",
                2300,
                new Address("Kolkata","India"),
                new ArrayList<>()
        );


        this.hotelRepository.deleteAll();
        List<Hotel> hotelList =  Arrays.asList(itc,ibis,novotel,hayatt);
        this.hotelRepository.saveAll(hotelList);
    }
}
