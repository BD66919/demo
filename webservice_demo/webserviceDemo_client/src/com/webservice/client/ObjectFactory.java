
package com.webservice.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.webservice.client package. 
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

    private final static QName _StudentQuery_QNAME = new QName("http://webservice_student_server/", "studentQuery");
    private final static QName _StudentQueryResponse_QNAME = new QName("http://webservice_student_server/", "studentQueryResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.webservice.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StudentQuery }
     * 
     */
    public StudentQuery createStudentQuery() {
        return new StudentQuery();
    }

    /**
     * Create an instance of {@link StudentQueryResponse }
     * 
     */
    public StudentQueryResponse createStudentQueryResponse() {
        return new StudentQueryResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentQuery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice_student_server/", name = "studentQuery")
    public JAXBElement<StudentQuery> createStudentQuery(StudentQuery value) {
        return new JAXBElement<StudentQuery>(_StudentQuery_QNAME, StudentQuery.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentQueryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice_student_server/", name = "studentQueryResponse")
    public JAXBElement<StudentQueryResponse> createStudentQueryResponse(StudentQueryResponse value) {
        return new JAXBElement<StudentQueryResponse>(_StudentQueryResponse_QNAME, StudentQueryResponse.class, null, value);
    }

}
