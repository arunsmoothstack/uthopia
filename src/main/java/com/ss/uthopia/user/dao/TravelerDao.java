package com.ss.uthopia.user.dao;

import com.ss.uthopia.user.entity.Traveler;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelerDao extends CrudRepository<Traveler, Long> {
    @Override
    List<Traveler> findAll();

}
