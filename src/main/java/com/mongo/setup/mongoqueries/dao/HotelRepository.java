package com.mongo.setup.mongoqueries.dao;

import com.mongo.setup.mongoqueries.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends MongoRepository<Hotel,String> {
}
