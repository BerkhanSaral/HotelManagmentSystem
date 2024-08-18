package com.tpe.HotelManagementSystem.repository;

import com.tpe.HotelManagementSystem.config.HibernateUtil;
import com.tpe.HotelManagementSystem.exception.HotelNotFoundException;
import com.tpe.HotelManagementSystem.model.Hotel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HotelRepositoryImpl implements HotelRepository {


    @Override
    public Hotel saveHotel(Hotel hotel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trs = session.beginTransaction();
        session.save(hotel);
        trs.commit();
        session.close();
        return hotel;
    }

    @Override
    public Hotel findHotelById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(Hotel.class, id);
    }

    @Override
    public void updateHotel(Hotel hotel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trs = session.beginTransaction();
        Hotel existingTHotel = session.get(Hotel.class, hotel.getId());
        if (existingTHotel != null) {
            existingTHotel.setName(hotel.getName());
            existingTHotel.setLocation(hotel.getLocation());
            session.update(existingTHotel);
        }
        trs.commit();
        session.close();
    }

    @Override
    public void deleteHotelById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trs = session.beginTransaction();
        Hotel hotelToDelete = session.get(Hotel.class, id);
        if (hotelToDelete != null) {
            session.delete(hotelToDelete);
            trs.commit();
        } else {
            throw new HotelNotFoundException("Hotel not found id : " + id);
        }
    }

    @Override
    public List<Hotel> findAllHotels() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Hotel", Hotel.class).getResultList();
    }
}










