package scripts;

import org.testng.annotations.Test;

import common.BaseClass;
import data.TC01_InvalidLoanAmountData;
import pageLocators.HomePage;
import pageLocators.LoanAmountPage;
import pageLocators.LoanEMIPage;
import pageMethods.HomeMethods;
import pageMethods.LoanAmountMethods;
import pageMethods.LoanBasicMethods;
import utils.ExtentReportsUtil;

public class Fin_04_InvalidInputsLoanBasicPage extends BaseClass {
	
	TC01_InvalidLoanAmountData data1 = new TC01_InvalidLoanAmountData();
	
	@Test
	public void Fin_04() throws Exception {
		ExtentReportsUtil.logstep("Fin_04 - Invalid Inputs - Loan Basic Page");
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
		
		ExtentReportsUtil.info("Enter Loan Details - Invalid Characters");
		lam.enterLoanDetailsTextbox(data1.getMonthlyPayment(), 
				data1.getAnnualInterestRate(), data1.getLoanDuration());
		lam.validateElementIsDisabled(LoanAmountPage.Calculate_Button);
		
		ExtentReportsUtil.info("Enter Loan Details - Invalid Interest Rate");
		data1.setCounter();
		lam.enterLoanDetailsTextbox(data1.getMonthlyPayment(), 
				data1.getAnnualInterestRate(), data1.getLoanDuration());
		lam.validateElementIsDisabled(LoanAmountPage.Calculate_Button);
		
		ExtentReportsUtil.info("Enter Loan Details - Invalid Loan Term Duration(Years)");
		data1.setCounter();
		lam.enterLoanDetailsTextbox(data1.getMonthlyPayment(), 
				data1.getAnnualInterestRate(), data1.getLoanDuration());
		lam.clickElement(LoanAmountPage.LoanTerm_Dropdown);
		lam.clickElement(LoanAmountPage.LoanTerm_Dropdown_Years);
		lam.validateElementIsDisabled(LoanAmountPage.Calculate_Button);
		
		ExtentReportsUtil.info("Enter Loan Details - Invalid Loan Term Duration(Months)");
		data1.setCounter();
		lam.enterLoanDetailsTextbox(data1.getMonthlyPayment(), 
				data1.getAnnualInterestRate(), data1.getLoanDuration());
		lam.clickElement(LoanAmountPage.LoanTerm_Dropdown);
		lam.clickElement(LoanAmountPage.LoanTerm_Dropdown_Months);
		lam.validateElementIsDisabled(LoanAmountPage.Calculate_Button);
		
		data1.resetCounter();
	}
}
