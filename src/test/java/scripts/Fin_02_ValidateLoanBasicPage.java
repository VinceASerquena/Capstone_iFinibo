package scripts;

import org.testng.annotations.Test;

import common.BaseClass;
import data.TC01_ValidateLoanAmountData;
import pageLocators.HomePage;
import pageLocators.LoanAmountPage;
import pageLocators.LoanEMIPage;
import pageMethods.HomeMethods;
import pageMethods.LoanAmountMethods;
import pageMethods.LoanBasicMethods;
import utils.ExtentReportsUtil;

public class Fin_02_ValidateLoanBasicPage extends BaseClass {
	
	TC01_ValidateLoanAmountData data1 = new TC01_ValidateLoanAmountData();
	
	@Test
	public void Fin_02() throws Exception {
		ExtentReportsUtil.logstep("Fin_02 - Validate Loan Basic Page");
		HomeMethods hpm = new HomeMethods(driver);
		
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
		
		ExtentReportsUtil.info("Enter Loan Details");
		lam.enterLoanDetailsTextbox(data1.getMonthlyPayment(), data1.getAnnualInterestRate(), data1.getLoanDuration());
		lam.clickElement(LoanAmountPage.LoanTerm_Dropdown);
		lam.clickElement(LoanAmountPage.LoanTerm_Dropdown_Months);
		lam.clickElement(LoanAmountPage.LoanTerm_Dropdown);
		lam.clickElement(LoanAmountPage.LoanTerm_Dropdown_Years);
		lam.clickElement(LoanAmountPage.Calculate_Button);
		
		ExtentReportsUtil.info("Clear Loan Details");
		lam.assertElementDisplayed(LoanAmountPage.Result_Header);
		lam.clickElement(LoanAmountPage.Clear_Button);
		lam.assertElementNotDisplayed(LoanAmountPage.Result_Header);
		
		ExtentReportsUtil.info("Enter Loan Details");
		lam.enterLoanDetailsTextbox(data1.getMonthlyPayment(), 
				data1.getAnnualInterestRate(), data1.getLoanDuration());
		lam.enterLoanTerms(data1.getLoanTerm());
		lam.clickElement(LoanAmountPage.Calculate_Button);
		
		ExtentReportsUtil.info("Validate Loan Calculate Results");
		lam.validateLoanCalculateResult();
		
		ExtentReportsUtil.info("Validate Loan Details");
		lam.clickElement(LoanAmountPage.Details_Button);
		lam.validateLoanDetailsYearlyTable();
		lam.validateLoanDetailsMonthlyTable();
		lam.validateLoanDetailsGraph();		
	}

}
