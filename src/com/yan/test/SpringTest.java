package com.yan.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringTest {

    public static void main(String[] args) {
     ApplicationContext ac = new FileSystemXmlApplicationContext("web/WEB-INF/applicationContext.xml");
     TestService ts = (TestService)ac.getBean("testService");
     ts.h();
    }

}