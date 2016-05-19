package exceptions;

public class RateException extends Exception {

	//private double returnRate;
	String Reason = "You Did Not Qualify For A Loan";
	public RateException() {
		//if (returnRate == 0)
		System.out.println(Reason);

	}

}

