package com.enset.presentation;

import com.enset.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXml {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationConfig.xml");
        IMetier metier=context.getBean(IMetier.class);
        System.out.println(metier.toString());
        System.out.println(metier.RealFois2());
    }
}
