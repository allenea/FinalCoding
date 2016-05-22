package rocketBase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.RateException;


public class rate_test {
	
	@Before
	public void setUp() throws Exception {

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
		
	} catch (RateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.err.println("You Do Not Qualify For A Loan");
	}

		//TODO - RocketBLL rate_test
		//		Check to see if a RateException is thrown if there are no rates for a given
		//		credit score
		
		
		




	
	}
	//@Test(expected=InsufficientF//undsException./cl//ass)
	@Test(expected = RateException.class)
	public void RateExceptionTest() throws RateException{
		double rate = RateBLL.getRate(300);
		//SEE IF EXCEPTION IS HANDLED WHEN AN UNACCEPTED INTEREST RATE IS GIVEN
		assertTrue(rate == 2.5);
		assertTrue(RateBLL.getRate(0)== 0);
	}

	@Test
	public void testPayment(){
		//r1 = new LoanRequest();
		//r1.setiCreditScore(700);
		//r1.setdAmount(300000);
		//r1.setiTerm(30);
		//r1.setiExpenses(0);
		//r1.setiIncome(0);
		double test1 = 0;
		try {
			test1 = RateBLL.getPayment(700, 30, 300000, 0, false);
		} 
		
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		assertEquals("$1432.25",(long)test1,(long)1432.25);

	}
	


}