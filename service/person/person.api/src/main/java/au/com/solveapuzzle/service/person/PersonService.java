package au.com.solveapuzzle.service.person;

import model.person.PersonRequestType;
import model.person.PersonResponseType;

/** Interface to represent the service facade for a Person.
 * Supports Query & Retrieval.
 * 
 * @author neilpiper
 *
 */
public interface PersonService {

	/** Given a PersonRequest (first, last names)
	 * return a matching PersonResponse
	 * 
	 * @param request
	 * @return
	 */
	PersonResponseType findPerson(PersonRequestType request);
	
}
