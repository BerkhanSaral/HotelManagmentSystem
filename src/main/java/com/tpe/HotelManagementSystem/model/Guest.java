package com.tpe.HotelManagementSystem.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_guests")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String tcNo;

    @Column(nullable = false)
    private String medeniDurum;

    @OneToMany(mappedBy = "guest")
    private List<Reservation> reservations = new ArrayList<>();

    //private Adress adress;


    public Guest(Long id, String name, String tcNo, String medeniDurum, List<Reservation> reservations) {
        this.id = id;
        this.name = name;
        this.tcNo = tcNo;
        this.medeniDurum = medeniDurum;
        this.reservations = reservations;
    }

    public Guest() {
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tcNo='" + tcNo + '\'' +
                ", medeniDurum='" + medeniDurum + '\'' +
                //", reservations=" + reservations +//zaten rezervasyonları listlemek icin bir methodumuz var!!!
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public void setMedeniDurum(String medeniDurum) {
        this.medeniDurum = medeniDurum;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTcNo() {
        return tcNo;
    }

    public String getMedeniDurum() {
        return medeniDurum;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }


}