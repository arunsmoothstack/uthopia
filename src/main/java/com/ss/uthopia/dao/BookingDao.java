package com.ss.uthopia.dao;

import com.ss.uthopia.entity.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDao extends CrudRepository<Booking, Long> {
    @Override
    List<Booking> findAll();
}
