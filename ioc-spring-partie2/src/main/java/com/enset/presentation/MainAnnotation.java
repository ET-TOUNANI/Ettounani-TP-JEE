package com.enset.presentation;


import com.enset.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAnnotation {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext("com");
        IMetier metier=context.getBean(IMetier.class);
        System.out.println(metier.toString());
        System.out.println(metier.RealFois2());
    }
}