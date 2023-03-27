# La création d'un web service
<img src="demo/app.png">
## Dependencies

```sh
<dependencies>
        <!-- https://mvnrepository.com/artifact/com.sun.xml.ws/jaxws-ri -->
        <dependency>
            <groupId>com.sun.xml.ws</groupId>
            <artifactId>jaxws-ri</artifactId>
            <version>4.0.1</version>
            <type>pom</type>
        </dependency>
</dependencies>
```
## wsdl

```sh
<definitions xmlns="http://schemas.xmlsoap.org/wsdl/" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tns="http://ws.ettounani.com/" xmlns:wsam="http://www.w3.org/2007/05/addressing/metadata" xmlns:wsp="http://www.w3.org/ns/ws-policy" xmlns:wsp1_2="http://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:xsd="http://www.w3.org/2001/XMLSchema" targetNamespace="http://ws.ettounani.com/" name="BanqueWS">
   <types>
      <xsd:schema>
         <xsd:import namespace="http://ws.ettounani.com/" schemaLocation="http://localhost:8087/?xsd=1" />
      </xsd:schema>
   </types>
   <message name="ConversionFromUroToDh">
      <part name="parameters" element="tns:ConversionFromUroToDh" />
   </message>
   <message name="ConversionFromUroToDhResponse">
      <part name="parameters" element="tns:ConversionFromUroToDhResponse" />
   </message>
   <message name="getCompte">
      <part name="parameters" element="tns:getCompte" />
   </message>
   <message name="getCompteResponse">
      <part name="parameters" element="tns:getCompteResponse" />
   </message>
   <portType name="BanqueService">
      <operation name="ConversionFromUroToDh">
         <input wsam:Action="http://ws.ettounani.com/BanqueService/ConversionFromUroToDhRequest" message="tns:ConversionFromUroToDh" />
         <output wsam:Action="http://ws.ettounani.com/BanqueService/ConversionFromUroToDhResponse" message="tns:ConversionFromUroToDhResponse" />
      </operation>
      <operation name="getCompte">
         <input wsam:Action="http://ws.ettounani.com/BanqueService/getCompteRequest" message="tns:getCompte" />
         <output wsam:Action="http://ws.ettounani.com/BanqueService/getCompteResponse" message="tns:getCompteResponse" />
      </operation>
   </portType>
   <binding name="BanqueServicePortBinding" type="tns:BanqueService">
      <soap:binding transport="http://schemas.xmlsoap.org/soap/http" style="document" />
      <operation name="ConversionFromUroToDh">
         <soap:operation soapAction="" />
         <input>
            <soap:body use="literal" />
         </input>
         <output>
            <soap:body use="literal" />
         </output>
      </operation>
      <operation name="getCompte">
         <soap:operation soapAction="" />
         <input>
            <soap:body use="literal" />
         </input>
         <output>
            <soap:body use="literal" />
         </output>
      </operation>
   </binding>
   <service name="BanqueWS">
      <port name="BanqueServicePort" binding="tns:BanqueServicePortBinding">
         <soap:address location="http://localhost:8087/" />
      </port>
   </service>
</definitions>
```
> POJO : BanqueService

```sh
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
    List<Compte> GetAllComptes(){
        return List.of(
                new Compte(1,Math.random()*9000,new Date()),
                new Compte(2,Math.random()*8000,new Date()),
                new Compte(3,Math.random()*7000,new Date())
        );
    }
}
```
> Entity  :  Compte

```sh
@XmlRootElement(name = "compte")
@XmlAccessorType(XmlAccessType.FIELD)
public class Compte {
    private int code;
    private double solde;
    @XmlTransient
    private Date dateCreation;
    public Compte(int code, double solde, Date dateCreation) {
        this.code = code;
        this.solde = solde;
        this.dateCreation = dateCreation;
    }
    public Compte() {
    }
   // getters & setters
   ...
}

```

> Local Server

```sh
public class MainServer {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8087/",new BanqueService());
        System.out.println("Web service deployé sur http://localhost:8087/");
    }
}
```

## Demo
<img src="demo/http.png">
> SoapUI

<img src="demo/new.png">
<img src="demo/SoapUI.png">
<img src="demo/req.png">

> Java Client 

