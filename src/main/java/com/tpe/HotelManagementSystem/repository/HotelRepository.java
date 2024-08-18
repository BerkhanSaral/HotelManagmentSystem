package com.tpe.HotelManagementSystem.repository;

import com.tpe.HotelManagementSystem.model.Hotel;

import java.util.List;

public interface HotelRepository {
    //5.adım otel icin gerekli methodlari icinde barındarına bir depo olusturduk
    //1. methodumuz create yani save methodu
    Hotel saveHotel(Hotel hotel);

    //2. methodumuz read yani find methodu
    Hotel findHotelById(Long id);

    //3. methodumuz update yani guncelleme methodu
    void updateHotel(Hotel hotel);

    //4. methodumuz delete yani silme methodu
    void deleteHotelById(Long id);

    List<Hotel> findAllHotels();
}