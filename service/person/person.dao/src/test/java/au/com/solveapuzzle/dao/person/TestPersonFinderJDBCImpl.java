package au.com.solveapuzzle.dao.person;

import model.person.ObjectFactory;
import model.person.PersonRequestType;
import model.person.PersonResponseType;

import org.junit.After;
import org.junit.Before;
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
	
	@Before
	public void setUp()
	{
		this.unitUnderTest.jdbcTemplate.execute("CREATE TABLE PERSON (FIRSTNAME VARCHAR(200) NOT NULL, LASTNAME VARCHAR(200) NOT NULL)");
	}
	
	@Test
    public void testQuery()
    {

    	ObjectFactory of = new ObjectFactory();
        PersonRequestType prt = of.createPersonRequestType();
        prt.setFirstName("FIRSTNAME");
    	prt.setSurname("SURNAME");
        
    	
    	
    	PersonResponseType response = this.unitUnderTest.findPerson(of.createPersonRequest(prt).getValue());
    	
    	
    }
	
	@After
	public void tearDown(){
		
		this.unitUnderTest.jdbcTemplate.execute("DROP TABLE PERSON");
	}
	
	
}
