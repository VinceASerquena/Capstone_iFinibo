package pageMethods;

import common.BaseMethods;
import data.TC01_ValidateLoanAndEMIData;
import io.appium.java_client.android.AndroidDriver;
import pageLocators.LoanAmountPage;

public class LoanAmountMethods extends BaseMethods {
	
	public LoanAmountMethods(AndroidDriver driver) {
		super(driver);
	}
	
	public void enterLoanTerms(String loanTerm) throws Exception {
		TC01_ValidateLoanAndEMIData data = new TC01_ValidateLoanAndEMIData();
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

}
