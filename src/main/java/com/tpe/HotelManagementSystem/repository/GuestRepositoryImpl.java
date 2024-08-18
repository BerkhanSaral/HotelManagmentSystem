package com.tpe.HotelManagementSystem.repository;

import com.tpe.HotelManagementSystem.config.HibernateUtil;
import com.tpe.HotelManagementSystem.exception.GuestNotFoundException;
import com.tpe.HotelManagementSystem.model.Guest;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GuestRepositoryImpl implements GuestRepository {
    public Guest saveGuest(Guest guest) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trs = session.beginTransaction();
        session.save(guest);
        trs.commit();
        session.close();
        return guest;
    }

    public Guest findGuestById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(Guest.class, id);
    }

    public void deleteGuestById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trs = session.beginTransaction();
        Guest isExist = session.get(Guest.class, id);
        if (isExist != null) {
            session.delete(isExist.getId());
            trs.commit();
        } else {
            throw new GuestNotFoundException("this id does not exist : " + id);
        }
        session.close();
    }

    public void updateGuest(Guest updatedGuest) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trs = session.beginTransaction();
        Guest isExist = session.get(Guest.class, updatedGuest.getId());
        if (isExist != null) {
            isExist.setId(updatedGuest.getId());
            isExist.setName(updatedGuest.getName());
            isExist.setMedeniDurum(updatedGuest.getMedeniDurum());
            isExist.setTcNo(updatedGuest.getTcNo());
            isExist.setReservations(updatedGuest.getReservations());
            session.update(isExist);
        }
        trs.commit();
        session.close();
    }

    public List<Guest> findAllGuest() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Guest", Guest.class).getResultList();
    }
}
