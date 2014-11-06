package au.com.solveapuzzle.dao.person;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.person.ObjectFactory;
import model.person.Person;
import model.person.PersonRequestType;
import model.person.PersonResponseType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import au.com.solveapuzzle.service.person.PersonService;

@Repository
public class PersonFinderJDBCImpl implements PersonService {

	protected JdbcTemplate jdbcTemplate;
	
	public PersonResponseType findPerson(PersonRequestType request) {
		// TODO Auto-generated method stub
		
		jdbcTemplate.query("SELECT * FROM PERSON WHERE FIRSTNAME = '" + request.getFirstName() + "' AND LASTNAME = '" + request.getSurname() + "';", new PersonResultExtractor());
		return null;
	}
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	class PersonResultExtractor implements ResultSetExtractor<PersonResponseType>
	{

		public PersonResponseType extractData(ResultSet arg0)
				throws SQLException, DataAccessException {
			ObjectFactory personObjFactory = new model.person.ObjectFactory();
			PersonResponseType personResponse = personObjFactory.createPersonResponseType();
			
			
			Person person = personObjFactory.createPerson();
			
			
			// TODO Auto-generated method stub
			return personResponse;
		}
		
	}
	
}
