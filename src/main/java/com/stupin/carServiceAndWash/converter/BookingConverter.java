package com.stupin.carServiceAndWash.converter;

import com.stupin.carServiceAndWash.dao.BookingDao;
import com.stupin.carServiceAndWash.dao.CarDao;
import com.stupin.carServiceAndWash.dto.Booking;
import com.stupin.carServiceAndWash.dto.Car;

import static com.stupin.carServiceAndWash.converter.UserConverter.toDao;
import static com.stupin.carServiceAndWash.converter.UserConverter.toDto;

public class BookingConverter {
    public static Booking bookingToDto(BookingDao bookingDao) {
        return new Booking(
                bookingDao.getId(),
                bookingDao.getDate(),
                bookingDao.getDescription(),
                bookingDao.getService(),
                bookingDao.getEmail(),
                toDto(bookingDao.getUserDao()));

    }

    public static BookingDao bookingToDao(Booking booking) {
        return new BookingDao(
                booking.getId(),
                booking.getDate(),
                booking.getDescription(),
                booking.getService(),
                booking.getEmail(),
                toDao(booking.getUser()));
    }
}
