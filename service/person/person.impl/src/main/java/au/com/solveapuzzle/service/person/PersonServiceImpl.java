package au.com.solveapuzzle.service.person;

import model.person.PersonRequestType;
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
	

	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "findPerson")
	@ResponsePayload
	public PersonResponseType findPerson(@RequestPayload PersonRequestType request) {
		
		return internalPersonFinder.findPerson(request);
	}

}
