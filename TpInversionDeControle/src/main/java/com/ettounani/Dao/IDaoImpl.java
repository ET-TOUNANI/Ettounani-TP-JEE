package com.ettounani.Dao;

import java.util.Date;

public class IDaoImpl implements IDao{
    @Override
    public Date getDate() {
        return new Date();
    }
}
