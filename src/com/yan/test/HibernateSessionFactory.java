package com.yan.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

    private  static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            Configuration config = new Configuration().configure();
            //读取并解析hibernate.cfg.xml配置文件
            //由hibernate.cfg.xml中的<mapping resource="com/xx/User.hbm.xml"/>读取并解析映射信息
            sessionFactory = config.buildSessionFactory();//创建sessionFactory
            return sessionFactory;
        }else{
            return sessionFactory;
        }
    }
}