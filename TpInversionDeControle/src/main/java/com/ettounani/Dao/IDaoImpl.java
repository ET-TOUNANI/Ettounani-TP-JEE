package com.ettounani.Dao;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class IDaoImpl implements IDao{
    @Override
    public Date getDate() {
        return new Date();
    }
}
