package com.tpe.HotelManagementSystem.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//2. adım hotel isimli bir class olusturduk ve bu classı entegre edebilmek entity ve table anatasyonlarını kullandık
@Entity
@Table(name = "tbl_hotels")
public class Hotel {

    //3. adım primary key yani ıd olusturma
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)//GenerationType.AUTO otomatik deger atamasi saglar// GenerationType.IDENTITY deger atama islemi database'e bırakılır
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @OneToMany(mappedBy = "hotel")
    private List<Room>rooms=new ArrayList<>();

    //4. adım daha hızlı deger ataması yapabilmek icin constructor olusturdum
    public Hotel() {//default constructor
    }

    public Hotel(String name, String location) {//parametreli constructor
        this.name = name;
        this.location = location;
    }
    //5. adım degerlerime erisebilmek icin getter setter methodlarını olusturdum


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
//Room isimli classı olusturucaz ve room uzerinde getter setter ve to string'i eklemeyi unutma!!!
}