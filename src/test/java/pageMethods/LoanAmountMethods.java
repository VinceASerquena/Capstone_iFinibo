package pageMethods;

import java.text.DecimalFormat;

import common.BaseMethods;
import data.TC01_ValidateLoanAmountData;
import io.appium.java_client.android.AndroidDriver;
import pageLocators.LoanAmountPage;

public class LoanAmountMethods extends BaseMethods {
	
	TC01_ValidateLoanAmountData data = new TC01_ValidateLoanAmountData();
	
	public LoanAmountMethods(AndroidDriver driver) {
		super(driver);
	}
	
	/**
	 * Validation of Loan Amount Elements
	 */
	public void validateLoanAmount() {
		assertElementDisplayed(LoanAmountPage.LoanAmount_Title);
		assertElementDisplayed(LoanAmountPage.MonthlyRepayment_Textbox);
		assertElementDisplayed(LoanAmountPage.AnnualInterestRate_Textbox);
		assertElementDisplayed(LoanAmountPage.LoanTerm_Textbox);
		assertElementDisplayed(LoanAmountPage.LoanTerm_Dropdown);
		assertElementDisplayed(LoanAmountPage.Clear_Button);
		assertElementDisplayed(LoanAmountPage.Calculate_Button);
	}
	
	/**
	 * Input of Loan Details to textbox elements based given Parameters
	 * @param MonthlyPayment
	 * @param AnnualInterest
	 * @param LoanDuration
	 */
	public void enterLoanDetailsTextbox(String MonthlyPayment, String AnnualInterest, String LoanDuration) throws Exception {
		data.getCounter();
		sendTextToElement(LoanAmountPage.MonthlyRepayment_Textbox, MonthlyPayment);
		sendTextToElement(LoanAmountPage.AnnualInterestRate_Textbox, AnnualInterest);
		sendTextToElement(LoanAmountPage.LoanTerm_Textbox, LoanDuration);
	}
	
	/**
	 * Enter Loan Terms to Dropdown element based on given parameter
	 * @param loanTerm
	 */
	public void enterLoanTerms(String loanTerm) throws Exception {
		
		data.getCounter();
		loanTerm = data.getLoanTerm();
		
		if (loanTerm.contentEquals("Years")) {
			clickElement(LoanAmountPage.LoanTerm_Dropdown);
			clickElement(LoanAmountPage.LoanTerm_Dropdown_Years);
			
		}
		else if (loanTerm.contentEquals("Months")) {
			clickElement(LoanAmountPage.LoanTerm_Dropdown);
			clickElement(LoanAmountPage.LoanTerm_Dropdown_Months);
		}
	}
	
	/**
	 * Validation of Loan Calculate Results
	 */
	public void validateLoanCalculateResult() throws Exception {
		data.getCounter();
		DecimalFormat df = new DecimalFormat("#,##,##,###.00");
		assertElementDisplayed(LoanAmountPage.LoanAmount_Text);
		validateIfCorrectText(LoanAmountPage.LoanAmount_Value, df.format(Double.parseDouble(data.getLoanAmount())));
		assertElementDisplayed(LoanAmountPage.NumOfPayments_Text);
		validateIfCorrectText(LoanAmountPage.NumOfPayments_Value, data.getNumberOfPayments());
		assertElementDisplayed(LoanAmountPage.TotalInterest_Text);
		validateIfCorrectText(LoanAmountPage.TotalInterest_Value, df.format(Double.parseDouble(data.getTotalInterest())));
		assertElementDisplayed(LoanAmountPage.TotalPayment_Text);
		validateIfCorrectText(LoanAmountPage.TotalPayment_Value, df.format(Double.parseDouble(data.getTotalPayment())));
	}
	
	/**
	 * Validate Loan Details - Yearly Table
	 */
	public void validateLoanDetailsYearlyTable() {
		assertElementDisplayed(LoanAmountPage.Table_Graph);
		assertElementDisplayed(LoanAmountPage.TY_YearNumber_Header);
		assertElementDisplayed(LoanAmountPage.TY_PrincipalPaid_Header);
		assertElementDisplayed(LoanAmountPage.TY_InterestPaid_Header);
		assertElementDisplayed(LoanAmountPage.TY_YearEndLoanBalance_Header);
	}
	
	/**
	 * Validate Loan Details - Monthly Table
	 */
	public void validateLoanDetailsMonthlyTable() {
		assertElementDisplayed(LoanAmountPage.Table_Monthly);
		clickElement(LoanAmountPage.Table_Monthly);
		assertElementDisplayed(LoanAmountPage.TM_YearNumber_Header);
		assertElementDisplayed(LoanAmountPage.TM_PrincipalPaid_Header);
		assertElementDisplayed(LoanAmountPage.TM_InterestPaid_Header);
		assertElementDisplayed(LoanAmountPage.TM_MonthEndLoanBalance_Header);
	}
	
	/**
	 * Validate Loan Details - Graph Table
	 */
	public void validateLoanDetailsGraph() {
		assertElementDisplayed(LoanAmountPage.Table_Graph);
		clickElement(LoanAmountPage.Table_Graph);
		assertElementDisplayed(LoanAmountPage.Graph_PieChart);
	}

}
