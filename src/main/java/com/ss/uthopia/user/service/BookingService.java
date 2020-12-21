package com.ss.uthopia.user.service;

import com.ss.uthopia.user.dao.BookingDao;
import com.ss.uthopia.user.entity.Booking;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {
    private BookingDao bookingDao;

    public BookingService(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    public Optional<Booking> findById(long id) {
        return this.bookingDao.findById(id);
    }
}
