package scripts;

import java.text.DecimalFormat;

import org.testng.annotations.Test;

import common.BaseClass;
import data.TC01_ValidateLoanAndEMIData;
import pageLocators.HomePage;
import pageLocators.LoanAmountPage;
import pageLocators.LoanEMIPage;
import pageMethods.HomeMethods;
import pageMethods.LoanAmountMethods;
import pageMethods.LoanBasicMethods;
import utils.ExtentReportsUtil;

public class TC01_ValidateLoanAndEMI extends BaseClass {
	
	TC01_ValidateLoanAndEMIData data = new TC01_ValidateLoanAndEMIData();
	
	@Test
	public void Fin_01() {
		ExtentReportsUtil.logstep("Fin_01 - Validate Home Page");
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
	public void Fin_02() throws Exception {
		ExtentReportsUtil.logstep("Fin_02 - Validate Loan Basic Page");
		HomeMethods hpm = new HomeMethods(driver);
		data.getCounter();
		//Navigate to Loan Basic Page
		hpm.assertElementDisplayed(HomePage.LAE_LoanBasic_Text);
		hpm.clickElement(HomePage.LAE_LoanBasic_Text);
		
		//Assert Elements
		ExtentReportsUtil.info("Validate Loan Basic Elements");
		LoanBasicMethods lbm = new LoanBasicMethods(driver);
		lbm.assertElementDisplayed(LoanEMIPage.LoanBasic_Title);
		lbm.assertElementDisplayed(LoanEMIPage.Calculator_Header);
		lbm.assertElementDisplayed(LoanEMIPage.MonthlyRepayment_Text);
		lbm.assertElementDisplayed(LoanEMIPage.LoanAmount_Text);
		lbm.assertElementDisplayed(LoanEMIPage.AnnualInterestRate_Text);
		lbm.assertElementDisplayed(LoanEMIPage.LoanTerm_Text);
		lbm.assertElementDisplayed(LoanEMIPage.Others_Header);
		lbm.assertElementDisplayed(LoanEMIPage.SaveLoan_Text);
		lbm.assertElementDisplayed(LoanEMIPage.VehicleLoan_Text);
		lbm.clickElement(LoanEMIPage.LoanAmount_Text);
		
		ExtentReportsUtil.info("Validate Loan Amount Elements");
		LoanAmountMethods lam = new LoanAmountMethods(driver);
		lam.assertElementDisplayed(LoanAmountPage.LoanAmount_Title);
		lam.assertElementDisplayed(LoanAmountPage.MonthlyRepayment_Textbox);
		lam.assertElementDisplayed(LoanAmountPage.AnnualInterestRate_Textbox);
		lam.assertElementDisplayed(LoanAmountPage.LoanTerm_Textbox);
		lam.assertElementDisplayed(LoanAmountPage.LoanTerm_Dropdown);
		lam.assertElementDisplayed(LoanAmountPage.Clear_Button);
		lam.assertElementDisplayed(LoanAmountPage.Calculate_Button);
		
		//Enter Values
		ExtentReportsUtil.info("Enter Loan Details");
		lam.sendTextToElement(LoanAmountPage.MonthlyRepayment_Textbox, data.getMonthlyPayment());
		lam.sendTextToElement(LoanAmountPage.AnnualInterestRate_Textbox, data.getAnnualInterestRate());
		lam.sendTextToElement(LoanAmountPage.LoanTerm_Textbox, data.getLoanDuration());
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
		lam.sendTextToElement(LoanAmountPage.MonthlyRepayment_Textbox, data.getMonthlyPayment());
		lam.sendTextToElement(LoanAmountPage.AnnualInterestRate_Textbox, data.getAnnualInterestRate());
		lam.enterLoanTerms(data.getLoanTerm());
		lam.sendTextToElement(LoanAmountPage.LoanTerm_Textbox, data.getLoanDuration());
		lam.clickElement(LoanAmountPage.Calculate_Button);
		
		//Calculate and Validate Results
		ExtentReportsUtil.info("Validate Loan Calculate Results");
		DecimalFormat df = new DecimalFormat("#,###,###.00");
		lam.assertElementDisplayed(LoanAmountPage.LoanAmount_Text);
		lam.validateIfCorrectText(LoanAmountPage.LoanAmount_Value, df.format(Double.parseDouble(data.getLoanAmount())));
		lam.assertElementDisplayed(LoanAmountPage.NumOfPayments_Text);
		lam.validateIfCorrectText(LoanAmountPage.NumOfPayments_Value, data.getNumberOfPayments());
		lam.assertElementDisplayed(LoanAmountPage.TotalInterest_Text);
		lam.validateIfCorrectText(LoanAmountPage.TotalInterest_Value, df.format(Double.parseDouble(data.getTotalInterest())));
		lam.assertElementDisplayed(LoanAmountPage.TotalPayment_Text);
		System.out.println(lam.getElementText(LoanAmountPage.TotalPayment_Value));
		System.out.println(df.format(Double.parseDouble(data.getTotalPayment())));
		lam.validateIfCorrectText(LoanAmountPage.TotalPayment_Value, df.format(Double.parseDouble(data.getTotalPayment())));
		
		//Click Details and Validate Graph
		ExtentReportsUtil.info("Validate Loan Details");
		lam.clickElement(LoanAmountPage.Details_Button);
		
		lam.assertElementDisplayed(LoanAmountPage.Table_Graph);
		lam.assertElementDisplayed(LoanAmountPage.TY_YearNumber_Header);
		lam.assertElementDisplayed(LoanAmountPage.TY_PrincipalPaid_Header);
		lam.assertElementDisplayed(LoanAmountPage.TY_InterestPaid_Header);
		lam.assertElementDisplayed(LoanAmountPage.TY_YearEndLoanBalance_Header);
		
		lam.assertElementDisplayed(LoanAmountPage.Table_Monthly);
		lam.clickElement(LoanAmountPage.Table_Monthly);
		lam.assertElementDisplayed(LoanAmountPage.TM_YearNumber_Header);
		lam.assertElementDisplayed(LoanAmountPage.TM_PrincipalPaid_Header);
		lam.assertElementDisplayed(LoanAmountPage.TM_InterestPaid_Header);
		lam.assertElementDisplayed(LoanAmountPage.TM_MonthEndLoanBalance_Header);
		
		lam.assertElementDisplayed(LoanAmountPage.Table_Graph);
		lam.clickElement(LoanAmountPage.Table_Graph);
		lam.assertElementDisplayed(LoanAmountPage.Graph_PieChart);;
		
	}
	
	@Test
	public void Fin_03() {
		ExtentReportsUtil.logstep("Validate Vehicle Loan Page");
		
	}
}
