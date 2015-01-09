package au.com.solveapuzzle.service.person;

import model.person.PersonRequestType;
import javax.xml.bind.JAXBElement;
import model.person.PersonResponseType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PersonServiceImpl {

	private static final String NAMESPACE_URI = "http://www.example.org/PersonService/v1";

	@Autowired
	public PersonService internalPersonFinder;
	
	// We've put JAXBElement due to the following -- https://jbossadventure.wordpress.com/2013/04/16/spring-ws-no-adapter-for-endpoint/

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "findPerson")
	@ResponsePayload
	public PersonResponseType findPerson(@RequestPayload PersonRequestType request) {
		
		//throw new RuntimeException("SOAP FAULT!!");
		
		return internalPersonFinder.findPerson(request);
	}

}
