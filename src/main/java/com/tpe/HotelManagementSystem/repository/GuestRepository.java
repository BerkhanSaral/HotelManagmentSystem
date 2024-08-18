package com.tpe.HotelManagementSystem.repository;

import com.tpe.HotelManagementSystem.model.Guest;

import java.util.List;

public interface GuestRepository {
    Guest saveGuest(Guest guest);

    Guest findGuestById(Long id);

    void deleteGuestById(Long id);

    void updateGuest(Guest updatedGuest);

    List<Guest> findAllGuest();

    //bunun classını olusturup methodlari doldurmasi odev!!!+guest service
}