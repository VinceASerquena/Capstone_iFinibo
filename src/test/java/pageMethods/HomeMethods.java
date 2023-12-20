package pageMethods;

import common.BaseMethods;
import io.appium.java_client.android.AndroidDriver;
import pageLocators.HomePage;

public class HomeMethods extends BaseMethods {
	
	public HomeMethods(AndroidDriver driver) {
		super(driver);
	} 
	
	/**
	 * Validation of Home Elements
	 */
	public void validateHomeLoanEMI() {
		assertElementDisplayed(HomePage.Title);
		assertElementDisplayed(HomePage.LoanAndEmi_Header);
		assertElementDisplayed(HomePage.LoanAndEmi_Collapse);
		assertElementDisplayed(HomePage.LAE_LoanBasic_Text);
		assertElementDisplayed(HomePage.LAE_LoanAdvance_Text);
		assertElementDisplayed(HomePage.LAE_CompareLoan_Text);
		assertElementDisplayed(HomePage.LAE_LoanAmountEligibility_Text);
		assertElementDisplayed(HomePage.LAE_HomeLoanDocuments_Text);
	}
	
	/**
	 * Validation of LoanEMI Collapse Function
	 */
	public void validateLoanEMICollapse() {
		clickElement(HomePage.LoanAndEmi_Collapse);
		assertElementNotDisplayed(HomePage.LAE_LoanBasic_Text);
	}
	
	/**
	 * Validate of LoanEMI Expand Function
	 */
	public void validateLoanEMIExpand() {
		clickElement(HomePage.LoanAndEmi_Collapse);
		assertElementDisplayed(HomePage.LAE_LoanBasic_Text);
		assertElementDisplayed(HomePage.LAE_LoanAdvance_Text);
		assertElementDisplayed(HomePage.LAE_CompareLoan_Text);
		assertElementDisplayed(HomePage.LAE_LoanAmountEligibility_Text);
		assertElementDisplayed(HomePage.LAE_HomeLoanDocuments_Text);
	}
}
