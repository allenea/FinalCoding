package rocketBase;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;

import java.util.ArrayList;
import rocketDomain.RateDomainModel;

//import org.apache.poi.ss.formula.functions.FinanceLib;



public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();

	public static double getRate(int GivenCreditScore)  throws RateException {
		//TODO - RocketBLL RateBLL.getRate - make sure you throw any exception
		
		//		Call RateDAL.getAllRates... this returns an array of rates
		//		write the code that will search the rates to determine the 
		//		interest rate for the given credit score
		//		hints:  you have to sort the rates...  you can do this by using
		//			a comparator... or by using an OrderBy statement in the HQL
		
		
		//TODO - RocketBLL RateBLL.getRate
		//			obviously this should be changed to return the determined rate

		ArrayList<RateDomainModel> rates = new ArrayList<RateDomainModel>(RateDAL.getAllRates());
		double returnRate = 0;
		//FOR
		for (RateDomainModel rate: rates)
		{
			//If
			if (GivenCreditScore >= rate.getiMinCreditScore()){
				returnRate = rate.getdInterestRate();
					}

			else{
				throw new RateException();
				
			/*{
				if(GivenCreditScore < rate.getiMinCreditScore()){
					//Object message = null;
					throw new RateException(returnRate);
					//System.out.println( "You Did Not Qualify For A Loan");

				}
				*/
			}
			continue;
		}
		return returnRate;

	}
	
	
	
	
	//TODO - RocketBLL RateBLL.getPayment 
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	
	//r - rate
	//n - num of periods
	//y - pmt per period
	//p - Present Value value
	//F - should = 0 //// + # says you owe money
	//t - type (false=pmt at begining of period)
	//MAKE R N P AND F
	
	//MATH.ABS takes absolute value  to make it positive..
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		double mPayment;
		double rate1 = r/1200;
		mPayment = Math.abs(FinanceLib.pmt(rate1, n, p, 0, false));
		return mPayment;
	}
	/*
	public boolean RateApproval(double mPayment,double iIncome,double iExpenses){
		if (mPayment > iIncome * 0.36){
			return false;
		}
		else if(mPayment > (iIncome+iExpenses) * 0.28){
			return false;
		}
		else{
			//THROW EXCEPTION IN HERE!!!!
			return true;

		}
		
	}
	*/
	
}
