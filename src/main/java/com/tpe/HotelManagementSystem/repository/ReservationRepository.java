package com.tpe.HotelManagementSystem.repository;

import com.tpe.HotelManagementSystem.model.Hotel;
import com.tpe.HotelManagementSystem.model.Reservation;

import java.util.List;

public interface ReservationRepository {
    //5.adım rezervasyon icin gerekli methodlari icinde barındarına bir depo olusturduk
    //1. methodumuz create yani save methodu
    Reservation saveReservation(Reservation reservation);
    //2. methodumuz read yani find methodu
    Reservation findReservationById(Long id);

    //3. methodumuz update yani guncelleme methodu
    void updateReservation(Reservation reservation);

    //4. methodumuz delete yani silme methodu
    void deleteReservationById(Long id);

    List<Reservation> findAllReservations();
}
