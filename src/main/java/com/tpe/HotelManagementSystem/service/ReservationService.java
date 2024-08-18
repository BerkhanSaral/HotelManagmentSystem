package com.tpe.HotelManagementSystem.service;

import com.tpe.HotelManagementSystem.exception.ReservationNotFoundException;
import com.tpe.HotelManagementSystem.model.Guest;
import com.tpe.HotelManagementSystem.model.Reservation;
import com.tpe.HotelManagementSystem.model.Room;
import com.tpe.HotelManagementSystem.repository.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ReservationService {
    ReservationRepository reservationRepository = new ReservationRepositoryImpl();
    RoomRepository roomRepository=new RoomRepositoryImpl();

    GuestRepository guestRepository;//new GuestRepositoryImpl(); bu class persembe gunune olusturulcak
    Scanner scanner = new Scanner(System.in);

    public Reservation saveReservation() {
        Reservation reservation = new Reservation();

        System.out.println("Lutfen rezervasyon id`yi giriniz");
        reservation.setId(scanner.nextLong());

        System.out.println("Lutfen misafirimiz id'sini giriniz");
        Long guestId=scanner.nextLong();
        Guest guest=guestRepository.findGuestById(guestId);

        System.out.println("Lutfen giris tarihini (yyyy/mm/dd) formatinda giriniz");
        int years=scanner.nextInt();
        int month=scanner.nextInt();
        int day=scanner.nextInt();
        reservation.setCheckInDate(LocalDate.of(years,month,day));

        System.out.println("Lutfen cikis tarihini (yyyy/mm/dd) formatinda giriniz");
        years=scanner.nextInt();
        month=scanner.nextInt();
        day=scanner.nextInt();
        reservation.setCheckInDate(LocalDate.of(years,month,day));

        System.out.println("Lutfen oda idnizi giriniz");
        Long roomId = scanner.nextLong();
        Room findedRoom=roomRepository.findRoomById(roomId);
        reservation.setRoom(findedRoom);
        reservation.setGuest(guest);
        reservationRepository.saveReservation(reservation);
        System.out.println("Reservasyon basarili bir sekilde olusturuldu");
        return reservation;

    }

    public Reservation findReservationById(Long id) {
        Reservation isExists = reservationRepository.findReservationById(id);
        if (isExists != null) {
            System.out.println("-----------------");
            System.out.println(isExists);
            return isExists;
        } else {
            throw new ReservationNotFoundException("This reservaton does not exist : " + id);
        }
    }

    public void updateReservation(Long id, Reservation reserva) {
        Reservation existingReserva = reservationRepository.findReservationById(id);
        if (existingReserva == null) {
            throw new ReservationNotFoundException("This reservaton does not exist : " + id);
        }
        existingReserva.setId(reserva.getId());
        existingReserva.setCheckInDate(reserva.getCheckInDate());
        existingReserva.setCheckOutDate(reserva.getCheckOutDate());
        existingReserva.setRoom(reserva.getRoom());
        reservationRepository.updateReservation(reserva);
        System.out.println("updated succesfully");
    }


    public void deleteReservationById(Long id) {
        Reservation deleteToReserva = reservationRepository.findReservationById(id);
        if (deleteToReserva == null) {
            throw new ReservationNotFoundException("This reservaton does not exist : " + id);
        }
        reservationRepository.deleteReservationById(deleteToReserva.getId());
        System.out.println("this reservation is deleted successfully ");
    }

    public List<Reservation> findAllReservations() {
        List<Reservation> resultList = reservationRepository.findAllReservations();
        if (!resultList.isEmpty()) {
            for (Reservation r : resultList) {
                System.out.println(r);
                System.out.println("----------------------");
            }
        } else {
            System.out.println("Reservation list is empty");
        }
        return resultList;
    }
}