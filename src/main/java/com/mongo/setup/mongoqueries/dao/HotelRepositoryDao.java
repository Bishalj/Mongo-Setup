package com.mongo.setup.mongoqueries.dao;

import com.mongo.setup.mongoqueries.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepositoryDao extends MongoRepository<Hotel,String> {
    List<Hotel> findByPricePerNightLessThan(int maxPrice);

}
