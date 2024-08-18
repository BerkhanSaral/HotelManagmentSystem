package com.tpe.HotelManagementSystem.repository;

import com.tpe.HotelManagementSystem.model.Hotel;
import com.tpe.HotelManagementSystem.model.Room;

import java.util.List;

public interface RoomRepository {
    //5.adım otel icin gerekli methodlari icinde barındarına bir depo olusturduk
    //1. methodumuz create yani save methodu
    Room saveRoom(Room room);

    //2. methodumuz read yani find methodu
    Room findRoomById(Long id);

    //3. methodumuz update yani guncelleme methodu
    void updateRoom(Room room);

    //4. methodumuz delete yani silme methodu
    void deleteRoomById(Long id);

    List<Room> findAllRoom();

}
