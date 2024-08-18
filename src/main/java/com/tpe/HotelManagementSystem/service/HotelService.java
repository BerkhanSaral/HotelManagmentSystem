package com.tpe.HotelManagementSystem.service;

import com.tpe.HotelManagementSystem.exception.HotelNotFoundException;
import com.tpe.HotelManagementSystem.model.Hotel;
import com.tpe.HotelManagementSystem.repository.HotelRepository;
import com.tpe.HotelManagementSystem.repository.HotelRepositoryImpl;

import java.util.List;
import java.util.Scanner;

public class HotelService {

    private HotelRepository hotelRepository = new HotelRepositoryImpl();
    private Scanner scanner = new Scanner(System.in);


    public Hotel saveHotel() {
        Hotel hotel = new Hotel();
        System.out.println("Lutfen otelin ismini giriniz");
        hotel.setName(scanner.nextLine());

        System.out.println("Lutfen otelin adresini girini");
        hotel.setLocation(scanner.nextLine());

        hotelRepository.saveHotel(hotel);
        System.out.println("Hotel basarili bir sekilde olusturuldu");
        return hotel;
    }


    public Hotel findHotelById(Long id) {
        Hotel hotel = hotelRepository.findHotelById(id);
        try {
            if (hotel != null) {
                System.out.println("-----------------------------");
                System.out.println(hotel);
                return hotel;
            } else {
                throw new HotelNotFoundException("Hotel not found with id : " + id);
            }
        } catch (HotelNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public void updateHotel(Hotel updatedHotel, Long id) {
        Hotel existingHotel = hotelRepository.findHotelById(id);
        try {
            if (existingHotel == null) {
                throw new HotelNotFoundException("Hotel not found with id : " + id);
            } else {
                existingHotel.setName(updatedHotel.getName());
                existingHotel.setLocation(updatedHotel.getLocation());
                hotelRepository.updateHotel(existingHotel);
                System.out.println("updated succesfully");
            }
        } catch (HotelNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    public void deleteHotelById(Long id) {
        try {
            Hotel hotelToDelete = hotelRepository.findHotelById(id);
            if (hotelToDelete == null) {
                throw new HotelNotFoundException("Hotel not found with id : " + id);
            } else {
                hotelRepository.deleteHotelById(hotelToDelete.getId());
                System.out.println("this hotel is deleted successfully ");
            }
        } catch (HotelNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Hotel> findAllHotels() {
        List<Hotel> hotels = hotelRepository.findAllHotels();
        if (!hotels.isEmpty()) {
            for (Hotel h : hotels) {
                System.out.println(h);
                System.out.println("------------------------------------");
            }
        } else {
            System.out.println("Hotel list is empty");
        }
        return hotels;

        //hotel repoya baglamk gerkiyor oky
    }
}
