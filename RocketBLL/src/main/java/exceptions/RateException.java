package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateRomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a ge		RateDomainModel RateD = new RateDomainModel();
	RateDomainModel RateD = new RateDomainModel();

	public RateException(RateDomainModel rateDomain){
		
		RateD = rateDomain;
	}
	
	public RateDomainModel getRateD(){
		
		return RateD;
		
	
	//private double returnRate;
	//String Reason = "You Did Not Qualify For A Loan";
	//public RateException() {
		//if (Rate == 0)
		//System.out.println(Reason);

	}

}

