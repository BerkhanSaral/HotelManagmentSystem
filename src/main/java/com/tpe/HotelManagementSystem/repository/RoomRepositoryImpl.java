package com.tpe.HotelManagementSystem.repository;

import com.tpe.HotelManagementSystem.config.HibernateUtil;
import com.tpe.HotelManagementSystem.model.Hotel;
import com.tpe.HotelManagementSystem.model.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoomRepositoryImpl implements RoomRepository{//ödev!!! Methodlarin icerigini doldurun


    // @Override
    // public void updateRoom(Room room) {
//
    // }

    @Override
    public Room saveRoom(Room room) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(room);
            transaction.commit();
            return room;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Room findRoomById(Long roomId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(Room.class, roomId);
    }

    @Override
    public void updateRoom(Room room) {

    }


    @Override
    public List<Room> findAllRoom() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Room";
            List<Room> rooms = session.createQuery(hql, Room.class).getResultList();
            // System.out.println(rooms);
            return rooms;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    @Override
    public void deleteRoomById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Room room = session.get(Room.class, id);
            if (room != null) {

                Hotel hotel = room.getHotel();
                if (hotel != null) {
                    hotel.getRooms().remove(room);
                }

                session.delete(room);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}