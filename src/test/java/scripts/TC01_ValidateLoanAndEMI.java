package scripts;

import org.testng.annotations.Test;

import common.BaseClass;
import pageLocators.HomePage;
import pageMethods.HomeMethods;
import utils.ExtentReportsUtil;

public class TC01_ValidateLoanAndEMI extends BaseClass {
	
	@Test
	public void validateHome() {
		ExtentReportsUtil.logstep("Validate Home Page");
		HomeMethods hpm = new HomeMethods(driver);
		
		//validate elements
		ExtentReportsUtil.info("Validate Elements are Present");
		hpm.assertElementDisplayed(HomePage.Title);
		hpm.assertElementDisplayed(HomePage.LoanAndEmi_Header);
		hpm.assertElementDisplayed(HomePage.LoanAndEmi_Collapse);
		hpm.assertElementDisplayed(HomePage.LAE_LoanBasic_Text);
		hpm.assertElementDisplayed(HomePage.LAE_LoanAdvance_Text);
		hpm.assertElementDisplayed(HomePage.LAE_CompareLoan_Text);
		hpm.assertElementDisplayed(HomePage.LAE_LoanAmountEligibility_Text);
		hpm.assertElementDisplayed(HomePage.LAE_HomeLoanDocuments_Text);
		
		//Validate Collapse
		ExtentReportsUtil.info("Validate Loan And EMI Collapse");
		hpm.clickElement(HomePage.LoanAndEmi_Collapse);
		hpm.assertElementNotDisplayed(HomePage.LAE_LoanBasic_Text);
		hpm.assertElementNotDisplayed(HomePage.LAE_LoanAdvance_Text);
		hpm.assertElementNotDisplayed(HomePage.LAE_CompareLoan_Text);
		hpm.assertElementNotDisplayed(HomePage.LAE_LoanAmountEligibility_Text);
		hpm.assertElementNotDisplayed(HomePage.LAE_HomeLoanDocuments_Text);
		
		//Validate Options for Loan And EMI
		ExtentReportsUtil.info("Validate Loan And EMI Expand");
		hpm.clickElement(HomePage.LoanAndEmi_Collapse);
		hpm.assertElementDisplayed(HomePage.LAE_LoanBasic_Text);
		hpm.assertElementDisplayed(HomePage.LAE_LoanAdvance_Text);
		hpm.assertElementDisplayed(HomePage.LAE_CompareLoan_Text);
		hpm.assertElementDisplayed(HomePage.LAE_LoanAmountEligibility_Text);
		hpm.assertElementDisplayed(HomePage.LAE_HomeLoanDocuments_Text);
		
		//Print Options for Loan And EMI
		hpm.getElementsTextByXpath(HomePage.LoanAndEmi_ChildElements[2]);
	} 
	
	@Test
	public void validateBasicLoan() {
		ExtentReportsUtil.logstep("Validate Loan Basic Page");
	}
	
	@Test
	public void validateVehicleLoan() {
		ExtentReportsUtil.logstep("Validate Vehicle Loan Page");
		
	}
}
