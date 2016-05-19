package rocketBase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import exceptions.RateException;
import rocketData.LoanRequest;
import rocketDomain.RateDomainModel;


public class rate_test {
	private static LoanRequest r1;
	
	@Before
	public void setUp() throws Exception {
		r1 = new LoanRequest();
		r1.setiCreditScore(700);
		r1.setdAmount(300000);
		r1.setiTerm(30);
		r1.setiExpenses(0);
		r1.setiIncome(0);
	}


	@After
	public void tearDown() throws Exception {

	}
	// RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	// RocketDAL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	@Test
	public void testRate(){
	
	try {
		assertTrue(RateBLL.getRate(600) == 5);
		assertTrue(RateBLL.getRate(650) == 4.5);
		assertTrue(RateBLL.getRate(700) == 4);
		assertTrue(RateBLL.getRate(750) == 3.75);
		assertTrue(RateBLL.getRate(800) == 3.5);
		
		
		//TODO - RocketBLL rate_test
		//		Check to see if a RateException is thrown if there are no rates for a given
		//		credit score
		
		
		
		
		//SEE IF EXCEPTION IS HANDLED WHEN AN UNACCEPTED INTEREST RATE IS GIVEN
		assertTrue(RateBLL.getRate(300)== 2.5);
		assertTrue(RateBLL.getRate(800) == 3.5);
		assertTrue(RateBLL.getRate(0)== 0);
		
	} catch (RateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.err.println("You Do Not Qualify For A Loan");
	}


	
	
	}
	


}
