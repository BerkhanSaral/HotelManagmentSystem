package com.tpe.HotelManagementSystem.service;

import com.tpe.HotelManagementSystem.exception.GuestNotFoundException;
import com.tpe.HotelManagementSystem.model.Guest;
import com.tpe.HotelManagementSystem.model.Reservation;
import com.tpe.HotelManagementSystem.repository.GuestRepository;
import com.tpe.HotelManagementSystem.repository.GuestRepositoryImpl;
import com.tpe.HotelManagementSystem.repository.ReservationRepository;
import com.tpe.HotelManagementSystem.repository.ReservationRepositoryImpl;

import java.util.List;
import java.util.Scanner;

public class GuestService {
    ReservationRepository reservationRepository = new ReservationRepositoryImpl();
    GuestRepository guestService = new GuestRepositoryImpl();
    Scanner scanner = new Scanner(System.in);

    public Guest saveGuest() {

        Guest guest=new Guest();

        System.out.println("Lutfen ad-soyad giriniz");
        guest.setName(scanner.nextLine());

        System.out.println("Lutfen medeni durumunuzu giriniz (bekar-evli)");
        guest.setMedeniDurum(scanner.nextLine());

        System.out.println("Lutfen tc kimlik numaranizi giriniz");
        guest.setTcNo(scanner.nextLine());

        guestService.saveGuest(guest);
        System.out.println("Misafir basarili bir sekilde eklendi");
        return guest;

    }


    public Guest findGuestById(Long id) {
        Guest isExist = guestService.findGuestById(id);
        if (isExist == null) {
            throw new GuestNotFoundException("this guest does not exist : " + id);
        }
        System.out.println("-----------------");
        System.out.println(isExist);
        return isExist;
    }


    public void deleteGuestById(Long id) {
        Guest deletedGuest = guestService.findGuestById(id);
        if (deletedGuest == null) {
            throw new GuestNotFoundException("this guest does not exist : " + id);
        }
        guestService.deleteGuestById(id);
        System.out.println("Room deleted succesfully");

    }


    public void updateGuest(Guest updatedGuest, Long id) {
        Guest existGuest = guestService.findGuestById(id);
        if (existGuest == null) {
            throw new GuestNotFoundException("this guest does not exist : " + id);
        }
        existGuest.setName(updatedGuest.getName());
        existGuest.setMedeniDurum(updatedGuest.getMedeniDurum());
        existGuest.setTcNo(updatedGuest.getTcNo());
        guestService.updateGuest(existGuest);
        System.out.println("updated succesfully");

    }


    public List<Guest> findAllGuest() {
        List<Guest> guestList = guestService.findAllGuest();
        if (!guestList.isEmpty()) {
            for (Guest guest : guestList) {
                System.out.println(guest);
            }
        } else {
            System.out.println("Guest list is empty");
        }
        return guestList;
    }
}
