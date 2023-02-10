package com.ettounani.Presentation;
import com.ettounani.Dao.IDaoImpl;
import com.ettounani.Metier.IMetierImpl;

public class MainStatic {
    public static void main(String[] args) {
        IDaoImpl dao=new IDaoImpl();

        /* First way
        IMetierImpl metier=new IMetierImpl(dao);
         */
        IMetierImpl metier =new IMetierImpl();
        metier.setDao(dao);

        System.out.println(metier.calcul());
    }
}