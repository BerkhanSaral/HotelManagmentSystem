package com.tpe.HotelManagementSystem.config;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    //1. adım sessinfactory'i aktiflestirmem gerekiyor
    private static SessionFactory sessionFactory;
    static {
        try {
            Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
            sessionFactory=configuration.buildSessionFactory();
        } catch (Throwable e) {
            System.out.println("session factory olusturulken bir sorunla karşılaşıldı!!! "+ e);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void shutDown(){
        getSessionFactory().close();
    }



}