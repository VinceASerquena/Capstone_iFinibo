package pageMethods;

import java.text.DecimalFormat;

import common.BaseMethods;
import data.TC01_ValidateVehicleLoanData;
import io.appium.java_client.android.AndroidDriver;
import pageLocators.LoanAmountPage;
import pageLocators.VehicleLoanPage;

public class VehicleLoanMethods extends BaseMethods{
	
	TC01_ValidateVehicleLoanData data = new TC01_ValidateVehicleLoanData();
	
	public VehicleLoanMethods(AndroidDriver driver) {
		super(driver);
	}
	
	public void validateVehicleLoan() {
		assertElementDisplayed(VehicleLoanPage.VehicleLoan_Title);
		assertElementDisplayed(VehicleLoanPage.DownPaymentRequirement_Textbox);
		assertElementDisplayed(VehicleLoanPage.DownPaymentAmount_Textbox);
		assertElementDisplayed(VehicleLoanPage.AnnualInterestRate_Textbox);
		assertElementDisplayed(VehicleLoanPage.LoanTerm_Textbox);
		assertElementDisplayed(VehicleLoanPage.LoanTerm_Dropdown);
		assertElementDisplayed(VehicleLoanPage.Clear_Button);
		assertElementDisplayed(VehicleLoanPage.Calculate_Button);
	}

	public void enterLoanDetailsTextbox(String VehiclePrice, String DPRequirement, String DPAmount, String AnnualInterest, String LoanDuration) throws Exception {
		data.getCounter();
		sendTextToElement(VehicleLoanPage.VehiclePrice_Textbox, VehiclePrice);
		sendTextToElement(VehicleLoanPage.DownPaymentRequirement_Textbox, DPRequirement);
		sendTextToElement(VehicleLoanPage.DownPaymentAmount_Textbox, DPAmount);
		sendTextToElement(VehicleLoanPage.AnnualInterestRate_Textbox, AnnualInterest);
		sendTextToElement(VehicleLoanPage.LoanTerm_Textbox, LoanDuration);
	}
	
	public void enterLoanTerms(String loanTerm) throws Exception {
		
		data.getCounter();
		loanTerm = data.getLoanTerm();
		
		if (loanTerm.contentEquals("Years")) {
			clickElement(VehicleLoanPage.LoanTerm_Dropdown);
			clickElement(VehicleLoanPage.LoanTerm_Dropdown_Years);
			
		}
		else if (loanTerm.contentEquals("Months")) {
			clickElement(VehicleLoanPage.LoanTerm_Dropdown);
			clickElement(VehicleLoanPage.LoanTerm_Dropdown_Months);
		}
	}
	//update
	public void validateLoanCalculateResult() throws Exception {
		data.getCounter();
		DecimalFormat df = new DecimalFormat("#,##,##,###.00");
		assertElementDisplayed(VehicleLoanPage.MonthlyEMI_Text);
//		validateIfCorrectText(VehicleLoanPage.MonthlyEMI_Value, df.format(Double.parseDouble(data.getMonthlyEMI())));
		assertElementDisplayed(VehicleLoanPage.NumOfPayments_Text);
//		validateIfCorrectText(VehicleLoanPage.NumOfPayments_Value, data.getNumberOfPayments());
		assertElementDisplayed(VehicleLoanPage.TotalInterest_Text);
//		validateIfCorrectText(VehicleLoanPage.TotalInterest_Value, df.format(Double.parseDouble(data.getTotalInterest())));
		assertElementDisplayed(VehicleLoanPage.TotalPayment_Text);
//		validateIfCorrectText(VehicleLoanPage.TotalPayment_Value, df.format(Double.parseDouble(data.getTotalPayment())));
	}
	
	public void validateLoanDetailsYearlyTable() {
		assertElementDisplayed(VehicleLoanPage.Table_Graph);
		assertElementDisplayed(VehicleLoanPage.TY_YearNumber_Header);
		assertElementDisplayed(VehicleLoanPage.TY_PrincipalPaid_Header);
		assertElementDisplayed(VehicleLoanPage.TY_InterestPaid_Header);
		assertElementDisplayed(VehicleLoanPage.TY_YearEndLoanBalance_Header);
	}
	
	public void validateLoanDetailsMonthlyTable() {
		assertElementDisplayed(VehicleLoanPage.Table_Monthly);
		clickElement(VehicleLoanPage.Table_Monthly);
		assertElementDisplayed(VehicleLoanPage.TM_YearNumber_Header);
		assertElementDisplayed(VehicleLoanPage.TM_PrincipalPaid_Header);
		assertElementDisplayed(VehicleLoanPage.TM_InterestPaid_Header);
		assertElementDisplayed(VehicleLoanPage.TM_MonthEndLoanBalance_Header);
	}
	
	public void validateLoanDetailsGraph() {
		assertElementDisplayed(VehicleLoanPage.Table_Graph);
		clickElement(VehicleLoanPage.Table_Graph);
		assertElementDisplayed(VehicleLoanPage.Graph_PieChart);
	}
}
