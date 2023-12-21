package scripts;

import org.testng.annotations.Test;

import common.BaseClass;
import data.TC01_InvalidVehicleLoanData;
import pageLocators.HomePage;
import pageLocators.LoanEMIPage;
import pageLocators.VehicleLoanPage;
import pageMethods.HomeMethods;
import pageMethods.LoanBasicMethods;
import pageMethods.VehicleLoanMethods;
import utils.ExtentReportsUtil;

public class Fin_05_InvalidInputsVehicleLoanPage extends BaseClass {
	
	TC01_InvalidVehicleLoanData data2 = new TC01_InvalidVehicleLoanData();
	
	@Test
	public void Fin_05() throws Exception {
		
		ExtentReportsUtil.logstep("Fin_05 - Invalid Inputs - Vehicle Loan Page");
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
		vlm.validateElementIsDisabled(VehicleLoanPage.Calculate_Button);
		
	
	}
}
