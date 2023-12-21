package scripts;

import org.testng.annotations.Test;

import common.BaseClass;
import pageLocators.HomePage;
import pageMethods.HomeMethods;
import utils.ExtentReportsUtil;

public class Fin_01_ValidateHomePage extends BaseClass {
	
	@Test
	public void Fin_01() {
		
		ExtentReportsUtil.logstep("Fin_01 - Validate Home Page");
		HomeMethods hpm = new HomeMethods(driver);
			
		ExtentReportsUtil.info("Validate Elements are Present");
		hpm.validateHomeLoanEMI();
		
		ExtentReportsUtil.info("Validate Loan And EMI Collapse");
		hpm.validateLoanEMICollapse();
		
		ExtentReportsUtil.info("Validate Loan And EMI Expand");
		hpm.validateLoanEMIExpand();
		
		hpm.getElementsTextByXpath(HomePage.LoanAndEmi_ChildElements[2]);
	} 
}
