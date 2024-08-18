package com.tpe.HotelManagementSystem.main;

import com.tpe.HotelManagementSystem.model.Hotel;
import com.tpe.HotelManagementSystem.model.Room;
import com.tpe.HotelManagementSystem.service.GuestService;
import com.tpe.HotelManagementSystem.service.HotelService;
import com.tpe.HotelManagementSystem.service.ReservationService;
import com.tpe.HotelManagementSystem.service.RoomService;

import java.util.Scanner;

public class HotelManagmentSystemServiceClass {
    private static Scanner input=new Scanner(System.in);
    private static HotelService hotelService=new HotelService();
    private static ReservationService reservationService=new ReservationService();
    private static RoomService roomService=new RoomService();
    private  static GuestService guestService=new GuestService();
    public static void anaMenu(){

        boolean exit=false;
        while (!exit) {
            System.out.println("=========Hotel Managment System Menu==========");
            System.out.println("1. Otel işlemleri");
            System.out.println("2. Oda işlemleri");//ödev!!!
            System.out.println("3. Reservasyon işlemleri");//ödev!!!
            System.out.println("4. Konuk işlemleri");//ödev!!!
            System.out.println("5. Çıkış");
            System.out.println("Lütfen seçiminizi yapınız : ");
            int secim = input.nextInt();
            switch (secim) {
                case 1:
                    otelIslemleriMenusu(hotelService);
                    break;
                case 2:
                    odaIslemleri(roomService);
                    break;
                case 3:
                    reservasyonIslemleri(reservationService);
                    break;
                case 4:
                    musteriIslemleri(guestService);
                    break;
                case 5:
                    System.out.println("Görüsmek üzere tekrar bekleriz");
                    exit=true;
                    break;
                default:
                    System.out.println("lütfen geçerli bir seçenek giriniz");
                    break;
            }
        }
    }


    private static void otelIslemleriMenusu(HotelService hotelService) {

        boolean exit=false;
        while (!exit){
            System.out.println("======Otel İşlemleri======");
            System.out.println("1. Yeni bir otel ekleme");
            System.out.println("2. Id ile otel arama");
            System.out.println("3. Id ile otel silme");
            System.out.println("4. Tüm otelleri listele");
            System.out.println("5. Id ile otel guncelleme");
            System.out.println("6. Ana Menuye dön");
            System.out.println("Lütfen seciminizi yapınız : ");
            int secim= input.nextInt();
            switch (secim){
                case 1:
                    hotelService.saveHotel();
                    break;
                case 2:
                    System.out.println("lütfen aramak istediginiz otelin id'sini giriniz");
                    Long hotelId=input.nextLong();
                    hotelService.findHotelById(hotelId);
                    break;
                case 3:
                    System.out.println("Lutfen silincek hotelin id`sini giriniz");
                    Long hotelDeleteId=input.nextLong();
                    hotelService.deleteHotelById(hotelDeleteId);
                    break;
                case 4:
                    hotelService.findAllHotels();
                    break;
                case 5:
                    System.out.println("Lütfen güncellemek istediginiz otelin Id'sini giriniz");
                    Long updatingHotelId= input.nextLong();
                    input.nextLine();
                    Hotel findedHotel=hotelService.findHotelById(updatingHotelId);
                    System.out.println("Lütfen ismini giriniz");
                    String name=input.nextLine();
                    System.out.println("Lütfen Lokasyonunu giriniz");
                    String location= input.nextLine();
                    Hotel updatedHotel=new Hotel(name,location);
                    updatedHotel.setId(findedHotel.getId());
                    hotelService.updateHotel(updatedHotel, updatingHotelId);
                    break;
                case 6:
                    System.out.println("Ana menüye yönlendiliyorsunuz");
                    exit=true;
                    break;
                default:
                    System.out.println("Yanlış bir seçim yaptınız tekrar deneyiniz :)");
                    break;
            }
        }
    }


    private static void odaIslemleri(RoomService roomService){
        boolean exit = false;
        while (!exit) {
            System.out.println("======Oda İşlemleri======");
            System.out.println("1. Oda ekleme");
            System.out.println("2. Id ile oda arama");
            System.out.println("3. Id ile oda silme");
            System.out.println("4. Tüm odalari listele");
            System.out.println("5. Ana Menuye dön");
            System.out.println("Lütfen seciminizi yapınız : ");
            int secim= input.nextInt();
            switch (secim){
                case 1:
                    roomService.saveRoom();
                    break;
                case 2:
                    System.out.println("Lütfen aramak istediginiz odanin id'sini giriniz");
                    roomService.findRoomById(input.nextLong());
                    break;
                case 3:
                    System.out.println("Lütfen silmek istediginiz odanin id'sini giriniz");
                    roomService.deleteRoomById(input.nextLong());
                    break;
                case 4:
                    roomService.findAllRooms();
                    break;
                case 5:
                    System.out.println("Ana menüye yonlendiliyorsunuz...");
                    exit=true;
                    break;
                default:
                    System.out.println("Lütfen gecerli bir secenek giriniz");
                    break;
            }


        }
    }

    private static void reservasyonIslemleri(ReservationService reservationService) {
        boolean exit = false;
        while (!exit) {
            System.out.println("======Reservasyon İşlemleri======");
            System.out.println("1. Rezervasyon olusturma");
            System.out.println("2. Id ile Rezervasyon arama");
            System.out.println("3. Id ile Rezervasyon silme");
            System.out.println("4. Tüm Rezervasyonlari listele");
            System.out.println("5. Ana Menuye dön");
            System.out.println("Lütfen seciminizi yapınız : ");
            int secim= input.nextInt();
            switch (secim){
                case 1:
                    reservationService.saveReservation();
                    break;
                case 2:
                    System.out.println("Lütfen aramak istediginiz rezervasyon id'sini giriniz");
                    reservationService.findReservationById(input.nextLong());
                    break;
                case 3:
                    System.out.println("Lütfen silmek istediginiz rezervasyon id'sini giriniz");
                    reservationService.deleteReservationById(input.nextLong());
                    break;
                case 4:
                    reservationService.findAllReservations();
                    break;
                case 5:
                    System.out.println("Ana menüye yonlendiriliyorsunuz");
                    exit=true;
                    break;
                default:
                    System.out.println("lütfen gecerli bir secim giriniz");
                    break;

            }

        }

    }
    private static void musteriIslemleri(GuestService guestService){
        boolean exit = false;
        while (!exit) {
            System.out.println("======Konuk İşlemleri======");
            System.out.println("1. Yeni Konuk olusturma");
            System.out.println("2. Id ile Konuk arama");
            System.out.println("3. Id ile Konuk silme");
            System.out.println("4. Tüm Konuklari listele");
            System.out.println("5. Ana Menuye dön");
            System.out.println("Lütfen seciminizi yapınız : ");
            int secim = input.nextInt();//65 56
            //input.nextLine();
            switch (secim){
                case 1:
                    guestService.saveGuest();
                    break;
                case 2:
                    System.out.println("Lütfen aramak istediginiz konuk'un id'sini giriniz");
                    guestService.findGuestById(input.nextLong());
                    break;
                case 3:
                    System.out.println("Lütfen silmek istediginiz Konuk'un id'sini giriniz");
                    guestService.deleteGuestById(input.nextLong());
                    break;
                case 4:
                    guestService.findAllGuest();
                    break;
                case 5:
                    System.out.println("Ana Menüye yonlendiriliyorsunuz...");
                    exit=true;
                    break;
                default:
                    System.out.println("lutfen gecerli bir secenek giriniz");
                    break;
            }



        }
    }


}