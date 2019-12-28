package com.yan.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import server.UserService;

import server.UserServiceImpl;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import server.daoimpl;
import server.serverimpl;

import java.util.List;
class HibernateTest {
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
    public static void main(String[] args) {
//        test1dao();
//        test2dao();
        test();
    }
    public static void test1dao(){

        ApplicationContext ac = new FileSystemXmlApplicationContext("web/WEB-INF/applicationContext.xml");
        serverimpl daoimpl = (serverimpl)ac.getBean("serverimpl");
        UserEntity user = new UserEntity();
        user.setName("test");
        user.setPassword("test");
        boolean x=daoimpl.save(user);
        System.out.println(x);
    }
    public static void test2dao(){

        ApplicationContext ac = new FileSystemXmlApplicationContext("web/WEB-INF/applicationContext.xml");
        serverimpl daoimpl = (serverimpl)ac.getBean("serverimpl");
        UserEntity user=daoimpl.find("ssh");
        System.out.println(user.getName()+"  " +user.getPassword());
        System.out.println("yes");
    }
    public static void test(){
        ApplicationContext ac = new FileSystemXmlApplicationContext("web/WEB-INF/applicationContext.xml");
        UserService userService = (UserServiceImpl)ac.getBean("user");
        UserEntity user = new UserEntity();
        user.setName("yan2");
        user.setPassword("23123123");
        userService.add(user);
        System.out.println("yes");
    }
}