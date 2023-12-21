package scripts;

import org.testng.annotations.Test;

import common.BaseClass;
import data.TC01_ValidateVehicleLoanData;
import pageLocators.HomePage;
import pageLocators.LoanAmountPage;
import pageLocators.LoanEMIPage;
import pageLocators.VehicleLoanPage;
import pageMethods.HomeMethods;
import pageMethods.LoanBasicMethods;
import pageMethods.VehicleLoanMethods;
import utils.ExtentReportsUtil;

public class Fin_03_ValidateVehicleLoanPage extends BaseClass {
	
	TC01_ValidateVehicleLoanData data2 = new TC01_ValidateVehicleLoanData();
	
	@Test
	public void Fin_03() throws Exception {
		
		ExtentReportsUtil.logstep("Fin_03 - Validate Vehicle Loan Page");
		data2.getCounter();
		
		HomeMethods hpm = new HomeMethods(driver);
		
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
		
		ExtentReportsUtil.info("Enter Vehicle Loan Details");
		vlm.enterLoanDetailsTextbox(data2.getVehiclePrice(),
				data2.getDownPaymentRequirement(), 
				data2.getDownPaymentAmount(), 
				data2.getAnnualInterstRate(),
				data2.getLoanDuration());
		vlm.enterLoanTerms(data2.getLoanTerm());
		vlm.clickElement(LoanAmountPage.Calculate_Button);
		
		ExtentReportsUtil.info("Validate Vehicle Loan Calculate Results");
		vlm.validateLoanCalculateResult();
		
		ExtentReportsUtil.info("Validate Vehicle Loan Details");
		vlm.clickElement(LoanAmountPage.Details_Button);
		vlm.validateLoanDetailsYearlyTable();
		vlm.validateLoanDetailsMonthlyTable();
		vlm.validateLoanDetailsGraph();
	
	}
}
