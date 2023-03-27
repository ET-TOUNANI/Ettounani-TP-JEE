
package com.ettounani.server.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ettounani.server.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConversionFromUroToDh_QNAME = new QName("http://ws.Server.ettounani.com/", "ConversionFromUroToDh");
    private final static QName _GetAllComptesResponse_QNAME = new QName("http://ws.Server.ettounani.com/", "GetAllComptesResponse");
    private final static QName _GetCompteResponse_QNAME = new QName("http://ws.Server.ettounani.com/", "getCompteResponse");
    private final static QName _GetCompte_QNAME = new QName("http://ws.Server.ettounani.com/", "getCompte");
    private final static QName _Compte_QNAME = new QName("http://ws.Server.ettounani.com/", "compte");
    private final static QName _ConversionFromUroToDhResponse_QNAME = new QName("http://ws.Server.ettounani.com/", "ConversionFromUroToDhResponse");
    private final static QName _GetAllComptes_QNAME = new QName("http://ws.Server.ettounani.com/", "GetAllComptes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ettounani.server.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCompte }
     * 
     */
    public GetCompte createGetCompte() {
        return new GetCompte();
    }

    /**
     * Create an instance of {@link GetCompteResponse }
     * 
     */
    public GetCompteResponse createGetCompteResponse() {
        return new GetCompteResponse();
    }

    /**
     * Create an instance of {@link GetAllComptesResponse }
     * 
     */
    public GetAllComptesResponse createGetAllComptesResponse() {
        return new GetAllComptesResponse();
    }

    /**
     * Create an instance of {@link ConversionFromUroToDh }
     * 
     */
    public ConversionFromUroToDh createConversionFromUroToDh() {
        return new ConversionFromUroToDh();
    }

    /**
     * Create an instance of {@link GetAllComptes }
     * 
     */
    public GetAllComptes createGetAllComptes() {
        return new GetAllComptes();
    }

    /**
     * Create an instance of {@link ConversionFromUroToDhResponse }
     * 
     */
    public ConversionFromUroToDhResponse createConversionFromUroToDhResponse() {
        return new ConversionFromUroToDhResponse();
    }

    /**
     * Create an instance of {@link Compte }
     * 
     */
    public Compte createCompte() {
        return new Compte();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConversionFromUroToDh }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.Server.ettounani.com/", name = "ConversionFromUroToDh")
    public JAXBElement<ConversionFromUroToDh> createConversionFromUroToDh(ConversionFromUroToDh value) {
        return new JAXBElement<ConversionFromUroToDh>(_ConversionFromUroToDh_QNAME, ConversionFromUroToDh.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllComptesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.Server.ettounani.com/", name = "GetAllComptesResponse")
    public JAXBElement<GetAllComptesResponse> createGetAllComptesResponse(GetAllComptesResponse value) {
        return new JAXBElement<GetAllComptesResponse>(_GetAllComptesResponse_QNAME, GetAllComptesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.Server.ettounani.com/", name = "getCompteResponse")
    public JAXBElement<GetCompteResponse> createGetCompteResponse(GetCompteResponse value) {
        return new JAXBElement<GetCompteResponse>(_GetCompteResponse_QNAME, GetCompteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.Server.ettounani.com/", name = "getCompte")
    public JAXBElement<GetCompte> createGetCompte(GetCompte value) {
        return new JAXBElement<GetCompte>(_GetCompte_QNAME, GetCompte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Compte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.Server.ettounani.com/", name = "compte")
    public JAXBElement<Compte> createCompte(Compte value) {
        return new JAXBElement<Compte>(_Compte_QNAME, Compte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConversionFromUroToDhResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.Server.ettounani.com/", name = "ConversionFromUroToDhResponse")
    public JAXBElement<ConversionFromUroToDhResponse> createConversionFromUroToDhResponse(ConversionFromUroToDhResponse value) {
        return new JAXBElement<ConversionFromUroToDhResponse>(_ConversionFromUroToDhResponse_QNAME, ConversionFromUroToDhResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllComptes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.Server.ettounani.com/", name = "GetAllComptes")
    public JAXBElement<GetAllComptes> createGetAllComptes(GetAllComptes value) {
        return new JAXBElement<GetAllComptes>(_GetAllComptes_QNAME, GetAllComptes.class, null, value);
    }

}
