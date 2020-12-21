package com.ss.uthopia.user.dao;

import com.ss.uthopia.user.entity.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDao extends CrudRepository<Booking, Long> {
    @Override
    List<Booking> findAll();
}
