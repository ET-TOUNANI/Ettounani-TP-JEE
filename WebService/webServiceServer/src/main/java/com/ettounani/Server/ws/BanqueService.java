package com.ettounani.Server.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Date;
import java.util.List;

//POJO : plain old java object
@WebService(serviceName = "BanqueWS")
public class BanqueService {
    @WebMethod(operationName = "ConversionFromUroToDh")
    public double conversion(@WebParam(name = "montant") double mt){
        return mt*10.5;
    }
    @WebMethod
    public Compte getCompte(@WebParam(name = "code") int code){
        return new Compte(code,Math.random()*9000,new Date());
    }
    @WebMethod(operationName = "GetAllComptes")
    public List<Compte> GetAllComptes(){
        return List.of(
                new Compte(1,Math.random()*9000,new Date()),
                new Compte(2,Math.random()*8000,new Date()),
                new Compte(3,Math.random()*7000,new Date())
        );
    }

}
