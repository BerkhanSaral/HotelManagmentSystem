package com.tpe.HotelManagementSystem.service;

import com.tpe.HotelManagementSystem.exception.HotelNotFoundException;
import com.tpe.HotelManagementSystem.exception.RoomNotFoundException;
import com.tpe.HotelManagementSystem.model.Hotel;
import com.tpe.HotelManagementSystem.model.Room;
import com.tpe.HotelManagementSystem.repository.HotelRepository;
import com.tpe.HotelManagementSystem.repository.HotelRepositoryImpl;
import com.tpe.HotelManagementSystem.repository.RoomRepository;
import com.tpe.HotelManagementSystem.repository.RoomRepositoryImpl;

import java.util.List;
import java.util.Scanner;

public class RoomService {

    private RoomRepository roomRepository = new RoomRepositoryImpl();
    private HotelRepository hotelRepository = new HotelRepositoryImpl();
    Scanner scanner = new Scanner(System.in);

    public Room saveRoom() {
        Room room = new Room();
        System.out.println("Lutfen oda numarasini giriniz");
        room.setNumber(scanner.nextLine());

        System.out.println("Lutfen oda kapasitesini giriniz");
        room.setCapacity(scanner.nextInt());

        System.out.println("Lutfen hotel id`yi giriniz");
        Long hotelId = scanner.nextLong();
        Hotel existingHotel = hotelRepository.findHotelById(hotelId);
        if (existingHotel == null) {
            throw new HotelNotFoundException("Hotel not found with id : " + hotelId);
        }
        room.setHotel(existingHotel);

        Room savedRoom = roomRepository.saveRoom(room);

        existingHotel.getRooms().add(savedRoom);

        System.out.println("Room saved succesfully");
        return savedRoom;
    }

    public void deleteRoomById(Long id) {
        Room findedRoom = roomRepository.findRoomById(id);
        if (findedRoom == null) {
            throw new RoomNotFoundException("Room not found with id : " + id);
        }
        roomRepository.deleteRoomById(id);
        System.out.println("Room deleted succesfully");
    }

    public void updateRoomById(Long id, Room room) {
        Room existingRoom = roomRepository.findRoomById(id);
        if (existingRoom == null) {
            throw new RoomNotFoundException("Room not found with id : " + id);
        }
        existingRoom.setNumber(room.getNumber());
        existingRoom.setCapacity(room.getCapacity());
        existingRoom.setHotel(room.getHotel());
        roomRepository.updateRoom(existingRoom);
        System.out.println("updated succesfully");
    }

    public List<Room> findAllRooms() {
        List<Room> rooms = roomRepository.findAllRoom();
        if (!rooms.isEmpty()) {
            for (Room room : rooms) {
                System.out.println(room);
            }
        } else {
            System.out.println("List is empty");
        }
        return rooms;
    }

    public Room findRoomById(Long id) {
        Room room = roomRepository.findRoomById(id);
        if (room == null) {
            throw new RoomNotFoundException("Room not found with id : " + id);
        }
        System.out.println("--------------------------------");
        System.out.println(room);
        return room;
    }
}

