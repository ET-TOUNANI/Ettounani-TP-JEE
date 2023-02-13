package com.enset.metier;

import com.enset.Dao.ComplexImpl;
import com.enset.Dao.IComplex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public final class MetierImpl implements IMetier{
    //@Autowired // we remove Autowired when we use the constructor
    IComplex complex;


    public MetierImpl(IComplex complex) {
        this.complex = complex;
    }

    @Override
    public double RealFois2() {
        return complex.realPart()*2;
    }
    public IComplex getComplex() {
        return complex;
    }
    public void setComplex(IComplex complex) {
        this.complex = complex;
    }

    @Override
    public String toString() {
        return  "("+complex.imaginPart()+"i+"+complex.realPart()+")";
    }
}
