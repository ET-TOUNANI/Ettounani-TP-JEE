package com.ettounani.Presentation;

import com.ettounani.Dao.IDao;
import com.ettounani.Metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MainDynamic {
    public static void main(String[] args) {
        try {
            Scanner scanner=new Scanner(new File("configs.txt"));

            String clsName1=scanner.nextLine();
            Class daoClass=Class.forName(clsName1);
            IDao dao=(IDao) daoClass.newInstance();

            String clsName2=scanner.nextLine();
            Class metierClass=Class.forName(clsName2);
            IMetier metier=(IMetier) metierClass.newInstance();

            Method setDao=metierClass.getMethod("setDao", IDao.class);
            setDao.invoke(metier,dao);

            System.out.println(metier.calcul());


        } catch (FileNotFoundException | ClassNotFoundException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}