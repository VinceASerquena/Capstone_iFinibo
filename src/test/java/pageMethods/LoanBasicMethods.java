package pageMethods;

import common.BaseMethods;
import io.appium.java_client.android.AndroidDriver;
import pageLocators.LoanEMIPage;

public class LoanBasicMethods extends BaseMethods {
	
	public LoanBasicMethods(AndroidDriver driver) {
		super(driver);
	}
	
	public void validateLoanBasic() {
		assertElementDisplayed(LoanEMIPage.LoanBasic_Title);
		assertElementDisplayed(LoanEMIPage.Calculator_Header);
		assertElementDisplayed(LoanEMIPage.MonthlyRepayment_Text);
		assertElementDisplayed(LoanEMIPage.LoanAmount_Text);
		assertElementDisplayed(LoanEMIPage.AnnualInterestRate_Text);
		assertElementDisplayed(LoanEMIPage.LoanTerm_Text);
		assertElementDisplayed(LoanEMIPage.Others_Header);
		assertElementDisplayed(LoanEMIPage.SaveLoan_Text);
		assertElementDisplayed(LoanEMIPage.VehicleLoan_Text);
	}
}
