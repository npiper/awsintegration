package au.com.solveapuzzle.dao.person;

import model.person.ObjectFactory;
import model.person.PersonRequestType;
import model.person.PersonResponseType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config.xml")
public class TestPersonFinderJDBCImpl {

	@Autowired
    protected PersonFinderJDBCImpl unitUnderTest;
	
	@Test
    public void testQuery()
    {

    	ObjectFactory of = new ObjectFactory();
        PersonRequestType prt = of.createPersonRequestType();
        prt.setFirstName("FIRSTNAME");
    	prt.setSurname("SURNAME");
        
    	
    	
    	PersonResponseType response = this.unitUnderTest.findPerson(of.createPersonRequest(prt).getValue());
    	
    	
    }
	
}
