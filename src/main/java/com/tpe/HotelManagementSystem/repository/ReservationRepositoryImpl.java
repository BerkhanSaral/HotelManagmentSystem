package com.tpe.HotelManagementSystem.repository;

import com.tpe.HotelManagementSystem.config.HibernateUtil;
import com.tpe.HotelManagementSystem.exception.ReservationNotFoundException;
import com.tpe.HotelManagementSystem.model.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReservationRepositoryImpl implements ReservationRepository {


    @Override
    public Reservation saveReservation(Reservation reservation) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trs = session.beginTransaction();
        session.save(reservation);
        trs.commit();
        session.close();
        return reservation;

    }

    @Override
    public Reservation findReservationById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(Reservation.class, id);

    }

    @Override
    public void updateReservation(Reservation reservation) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trs = session.beginTransaction();
        Reservation existsReservation = session.get(Reservation.class, reservation.getId());
        if (existsReservation != null) {
            existsReservation.setId(reservation.getId());
            existsReservation.setCheckInDate(reservation.getCheckInDate());
            existsReservation.setCheckOutDate(reservation.getCheckOutDate());
            existsReservation.setRoom(reservation.getRoom());
            session.update(reservation);
        }
        trs.commit();
        session.close();

    }

    @Override
    public void deleteReservationById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trs = session.beginTransaction();
        Reservation deleteToReservation = session.get(Reservation.class, id);
        if (deleteToReservation != null) {
            session.delete(deleteToReservation);
            trs.commit();
        } else {
            throw new ReservationNotFoundException("Reservation not found id : " + id);

        }
        session.close();
    }

    @Override
    public List<Reservation> findAllReservations() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Reservation", Reservation.class).getResultList();


    }
}