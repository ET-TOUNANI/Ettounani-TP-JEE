package com.enset.Dao;

import org.springframework.stereotype.Component;

//@Component
public final class ComplexImpl implements IComplex{
    final Double re;
    final  Double im;
    public ComplexImpl(Double re, Double im) {
        this.re = re;
        this.im = im;
    }
    @Override
    public Double imaginPart() {
        return im;
    }
    @Override
    public Double realPart() {
        return re;
    }
}
