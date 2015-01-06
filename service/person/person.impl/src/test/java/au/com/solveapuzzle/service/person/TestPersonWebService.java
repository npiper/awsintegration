package au.com.solveapuzzle.service.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"au.com.solveapuzzle.service.person","au.com.solveapuzzle.dao.person"})
@EnableAutoConfiguration
public class TestPersonWebService {

	public static void main(String[] args) {

		SpringApplication.run(TestPersonWebService.class, args);
	}

}
