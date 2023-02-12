package com.ettounani.Presentation;

import com.ettounani.Metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext("com");
        IMetier metier=context.getBean(IMetier.class);
        System.out.println("Result --> "+metier.calcul() +" :)");
    }
}
