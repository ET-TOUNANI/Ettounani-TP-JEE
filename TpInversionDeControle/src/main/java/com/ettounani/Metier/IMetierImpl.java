package com.ettounani.Metier;

import com.ettounani.Dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IMetierImpl implements IMetier{
    @Autowired
    IDao dao;
    // constructor
    public IMetierImpl(IDao dao) {
        this.dao = dao;
    }
    public IMetierImpl() {
    }

    @Override
    public double calcul() {
        return dao.getDate().getMinutes();
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }

    public IDao getDao() {
        return dao;
    }
}
