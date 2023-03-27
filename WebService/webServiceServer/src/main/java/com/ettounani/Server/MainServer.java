package com.ettounani.Server;

import com.ettounani.Server.ws.BanqueService;
import jakarta.xml.ws.Endpoint;

public class MainServer {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8087/",new BanqueService());

        System.out.println("Web service deployé sur http://localhost:8087/");
    }
}