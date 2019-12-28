package com.yan.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import server.UserService;

import server.UserServiceImpl;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

public class hiber {
    public boolean chick(String name,String pas){
        Transaction tx = null;
        try {
            //打开session
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            tx = session.beginTransaction();
            String sql = "from UserEntity where name= ?0 and password= ?1";
            Query query = session.createQuery(sql);
            query.setParameter(0,name);
            query.setParameter(1, pas);
            List<UserEntity> list = query.list();
            tx.commit();
            if (list.size() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean Register(UserEntity user) {
        // TODO Auto-generated method stub
        try {
            Session  session = HibernateSessionFactory.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
             session.save(user);
             tx.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}