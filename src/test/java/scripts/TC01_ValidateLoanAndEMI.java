package scripts;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import common.BaseClass;
import data.TC01_ValidateLoanAmountData;
import data.TC01_ValidateVehicleLoanData;
import pageLocators.HomePage;
import pageLocators.LoanAmountPage;
import pageLocators.LoanEMIPage;
import pageLocators.VehicleLoanPage;
import pageMethods.HomeMethods;
import pageMethods.LoanAmountMethods;
import pageMethods.LoanBasicMethods;
import pageMethods.VehicleLoanMethods;
import utils.ExtentReportsUtil;

public class TC01_ValidateLoanAndEMI extends BaseClass {
	
	TC01_ValidateLoanAmountData data1 = new TC01_ValidateLoanAmountData();
	TC01_ValidateVehicleLoanData data2 = new TC01_ValidateVehicleLoanData();
	
	@Test
	public void Fin_01() {
		ExtentReportsUtil.logstep("Fin_01 - Validate Home Page");
		HomeMethods hpm = new HomeMethods(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;	
		jse.executeScript("browserstack_executor: {'action': 'setSessionName', 'arguments': {'name': 'iFinibo Automation - Fin_01'}}");
		
		//validate elements
		ExtentReportsUtil.info("Validate Elements are Present");
		hpm.validateHomeLoanEMI();
		
		//Validate Collapse
		ExtentReportsUtil.info("Validate Loan And EMI Collapse");
		hpm.validateLoanEMICollapse();
		
		//Validate Options for Loan And EMI
		ExtentReportsUtil.info("Validate Loan And EMI Expand");
		hpm.validateLoanEMIExpand();
		
		//Print Options for Loan And EMI
		hpm.getElementsTextByXpath(HomePage.LoanAndEmi_ChildElements[2]);
	} 
	
	@Test
	public void Fin_02() throws Exception {
		ExtentReportsUtil.logstep("Fin_02 - Validate Loan Basic Page");
		HomeMethods hpm = new HomeMethods(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;	
		jse.executeScript("browserstack_executor: {'action': 'setSessionName', 'arguments': {'name': 'iFinibo Automation - Fin_02'}}");
		
		data1.getCounter();
		ExtentReportsUtil.info("Navigate to Loan Basic Page");
		hpm.assertElementDisplayed(HomePage.LAE_LoanBasic_Text);
		hpm.clickElement(HomePage.LAE_LoanBasic_Text);
		
		ExtentReportsUtil.info("Validate Loan Basic Elements");
		LoanBasicMethods lbm = new LoanBasicMethods(driver);
		lbm.validateLoanBasic();
		
		ExtentReportsUtil.info("Naviagate to Loan Amount Page");
		lbm.clickElement(LoanEMIPage.LoanAmount_Text);
		
		ExtentReportsUtil.info("Validate Loan Amount Eements");
		LoanAmountMethods lam = new LoanAmountMethods(driver);
		lam.validateLoanAmount();
		
		//Enter Values
		ExtentReportsUtil.info("Enter Loan Details");
		lam.enterLoanDetailsTextbox(data1.getMonthlyPayment(), data1.getAnnualInterestRate(), data1.getLoanDuration());
		lam.clickElement(LoanAmountPage.LoanTerm_Dropdown);
		lam.clickElement(LoanAmountPage.LoanTerm_Dropdown_Months);
		lam.clickElement(LoanAmountPage.LoanTerm_Dropdown);
		lam.clickElement(LoanAmountPage.LoanTerm_Dropdown_Years);
		lam.clickElement(LoanAmountPage.Calculate_Button);
		
		//Clear Values
		ExtentReportsUtil.info("Clear Loan Details");
		lam.assertElementDisplayed(LoanAmountPage.Result_Header);
		lam.clickElement(LoanAmountPage.Clear_Button);
		lam.assertElementNotDisplayed(LoanAmountPage.Result_Header);
		
		//Enter Values
		ExtentReportsUtil.info("Enter Loan Details");
		lam.enterLoanDetailsTextbox(data1.getMonthlyPayment(), data1.getAnnualInterestRate(), data1.getLoanDuration());
		lam.enterLoanTerms(data1.getLoanTerm());
		lam.clickElement(LoanAmountPage.Calculate_Button);
		
		//Calculate and Validate Results
		ExtentReportsUtil.info("Validate Loan Calculate Results");
		lam.validateLoanCalculateResult();
		
		//Click Details and Validate Graph
		ExtentReportsUtil.info("Validate Loan Details");
		lam.clickElement(LoanAmountPage.Details_Button);
		lam.validateLoanDetailsYearlyTable();
		lam.validateLoanDetailsMonthlyTable();
		lam.validateLoanDetailsGraph();		
	}
	
	@Test
	public void Fin_03() throws Exception {
		ExtentReportsUtil.logstep("Fin_03 - Validate Vehicle Loan Page");
		data2.getCounter();
		
		HomeMethods hpm = new HomeMethods(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;	
		jse.executeScript("browserstack_executor: {'action': 'setSessionName', 'arguments': {'name': 'iFinibo Automation - Fin_03'}}");
		
		ExtentReportsUtil.info("Navigate to Loan Basic Page");
		hpm.assertElementDisplayed(HomePage.LAE_LoanBasic_Text);
		hpm.clickElement(HomePage.LAE_LoanBasic_Text);
		
		ExtentReportsUtil.info("Navigate to Vehicle Loan Page");
		LoanBasicMethods lbm = new LoanBasicMethods(driver);
		lbm.assertElementDisplayed(LoanEMIPage.VehicleLoan_Text);
		lbm.clickElement(LoanEMIPage.VehicleLoan_Text);
		
		ExtentReportsUtil.info("Validate Vehicle Loan Eements");
		VehicleLoanMethods vlm = new VehicleLoanMethods(driver);
		vlm.validateVehicleLoan();
		
		ExtentReportsUtil.info("Enter Vehicle Loan Details");
		vlm.enterLoanDetailsTextbox(data2.getVehiclePrice(),
				data2.getDownPaymentRequirement(), 
				data2.getDownPaymentAmount(), 
				data2.getAnnualInterstRate(),
				data2.getLoanDuration());
		
		vlm.clickElement(VehicleLoanPage.LoanTerm_Dropdown);
		vlm.clickElement(VehicleLoanPage.LoanTerm_Dropdown_Months);
		vlm.clickElement(VehicleLoanPage.LoanTerm_Dropdown);
		vlm.clickElement(VehicleLoanPage.LoanTerm_Dropdown_Years);
		vlm.clickElement(VehicleLoanPage.Calculate_Button);
		
		ExtentReportsUtil.info("Clear Vehicle Loan Details");
		vlm.assertElementDisplayed(LoanAmountPage.Result_Header);
		vlm.clickElement(LoanAmountPage.Clear_Button);
		vlm.assertElementNotDisplayed(LoanAmountPage.Result_Header);
		
		//Enter Values
		ExtentReportsUtil.info("Enter Vehicle Loan Details");
		vlm.enterLoanDetailsTextbox(data2.getVehiclePrice(),
				data2.getDownPaymentRequirement(), 
				data2.getDownPaymentAmount(), 
				data2.getAnnualInterstRate(),
				data2.getLoanDuration());
		vlm.enterLoanTerms(data2.getLoanTerm());
		vlm.clickElement(LoanAmountPage.Calculate_Button);
		
		//Calculate and Validate Results
		ExtentReportsUtil.info("Validate Vehicle Loan Calculate Results");
		vlm.validateLoanCalculateResult();
		
		//Click Details and Validate Graph
		ExtentReportsUtil.info("Validate Vehicle Loan Details");
		vlm.clickElement(LoanAmountPage.Details_Button);
		vlm.validateLoanDetailsYearlyTable();
		vlm.validateLoanDetailsMonthlyTable();
		vlm.validateLoanDetailsGraph();
		
		vlm.navigateBack();
		vlm.navigateBack();
	
	}
}
