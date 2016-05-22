package rocket.app.view;

import java.text.DecimalFormat;

import eNums.eAction;
import exceptions.RateException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {
	@FXML
	TextField txtIncome;
	
	@FXML
	TextField txtExpenses;
	
	@FXML
	TextField txtCreditScore;
	
	@FXML
	TextField txtHouseCost;

	@FXML
	ComboBox<String> cmbTerm;

	
	@FXML
	Label lblMortgagePayment;
	
	//	Create private instance variables for:

	
	//		Labels   -  various labels for the controls
	//		Button   -  button to calculate the loan payment
	//		Label    -  to show error messages (exception throw, payment exception)

	
	private MainApp mainApp;
	
	//	TODO - RocketClient.RocketMainController


	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	private void initialize() {
		ObservableList<String> comboBox = FXCollections.observableArrayList("15 Years", "30 Years");
		cmbTerm.setItems(comboBox);
	}
	//	TODO - RocketClient.RocketMainController
	//			Call this when btnPayment is pressed, calculate the payment
	@FXML
	public void btnCalculatePayment(ActionEvent event) throws RateException
	{
		Object message = null;
		//	TODO - RocketClient.RocketMainController
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		//	TODO - RocketClient.RocketMainController
		//			set the loan request details...  rate, term, amount, credit score, downpayment
		//			I've created you an instance of lq...  execute the setters in lq
		
		lblMortgagePayment.setText("");
		//Income
		double Income = Double.parseDouble(txtIncome.getText());;
		lq.setiIncome(Income);
		System.out.println(Income);

		//expenses
		double Expenses = Double.parseDouble(txtExpenses.getText());;
		lq.setiExpenses(Expenses);
		System.out.println(Expenses);

		//Credit Score
		int CreditScore = (int)Double.parseDouble(txtCreditScore.getText());;
		lq.setiCreditScore(CreditScore);
		System.out.println(CreditScore);

		//Amount
		double HouseCosts = Double.parseDouble(txtHouseCost.getText());;
		lq.setdAmount(HouseCosts);
		System.out.println(HouseCosts);

		//TERM
		int Term = 0;
		if (cmbTerm.getValue()=="15 Years") {
			Term= 15*12;
		}
		//else (cmbTerm.getValue()=="30 Years") {
		else{
			Term= 30*12;
		}
			
		lq.setiTerm(Term);
		System.out.println(Term);
			

		
		a.setLoanRequest(lq);
			
			//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}

	@FXML
	public void HandleLoanRequestDetails(LoanRequest lRequest) {
		double payment;
		payment = lRequest.getdPayment();

		double x1 = (0.28*lRequest.getiIncome()/12);
		double x2 = (0.36*lRequest.getiIncome()/12) - lRequest.getiExpenses();
		if (payment >=x1 & payment >= x2){
			
			DecimalFormat dForm = new DecimalFormat("#,###.##");
			String mPay =  "Monthly Payment:  $"+ dForm.format(payment);
			System.out.println(mPay);
			//Double.toString(double)
			lblMortgagePayment.setText(mPay);
			}
		else{
			lblMortgagePayment.setText("You Cannot Afford This House");

		}
		
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		//return mPay;
	}	
}