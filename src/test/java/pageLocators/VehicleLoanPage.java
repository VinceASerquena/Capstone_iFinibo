package pageLocators;

public class VehicleLoanPage {
	
	public static final String[] VehicleLoan_Title = {"id", "Vehicle Loan Title", "com.ajra.emicalculator:id/text_title"};
	
	public static final String[] VehiclePrice_Textbox = {"id", "Vehicle Price Textbox", "com.ajra.emicalculator:id/control_car_price"};
	public static final String[] DownPaymentRequirement_Textbox = {"id", "Down Payment Requirement Textbox", "com.ajra.emicalculator:id/control_down_required"};
	public static final String[] DownPaymentAmount_Textbox = {"id", "Down Payment Amount Textbox", "com.ajra.emicalculator:id/control_down_payment"};
	public static final String[] AnnualInterestRate_Textbox = {"id", "Annual Interest Rate Textbox", "com.ajra.emicalculator:id/control_rate_of_interest"};
	public static final String[] LoanTerm_Textbox = {"id", "Loan Term Textbox", "com.ajra.emicalculator:id/control_loan_period"};
	public static final String[] LoanTerm_Dropdown = {"id", "Loan Term Dropdown", "android:id/text1"};
	public static final String[] LoanTerm_Dropdown_Years = {"xpath", "Loan Terms - Years", "//android.widget.TextView[@text = 'Years']"};
	public static final String[] LoanTerm_Dropdown_Months = {"xpath", "Loan Terms - Months", "//android.widget.TextView[@text = 'Months']"};
	
	public static final String[] Clear_Button = {"id", "Clear Button", "com.ajra.emicalculator:id/button_reset"};
	public static final String[] Calculate_Button = {"id", "Calculate Button", "com.ajra.emicalculator:id/button_calculate"};
	
	public static final String[] Result_Header = {"xpath", "Result Header", "//android.widget.TextView[@text = 'Result']"};
	
	//update
	public static final String[] MonthlyEMI_Text = {"xpath", "Monthly EMI Text", "//android.widget.TextView[@text = 'Monthly EMI']"};
	public static final String[] MonthlyEMI_Value = {"xpath", "Monthly EMI Value", MonthlyEMI_Text[2] + "/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView[2]"};
	public static final String[] NumOfPayments_Text = {"xpath", "Number of Payments Text", "//android.widget.TextView[@text = 'No Of Payments']"};
	public static final String[] NumOfPayments_Value = {"xpath", "Number of Payments Value", NumOfPayments_Text[2] + "/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView"};
	public static final String[] TotalInterest_Text = {"xpath", "Total Interest Text", "//android.widget.TextView[@text = 'Total Interest']"};
	public static final String[] TotalInterest_Value = {"xpath", "Total Interest Value", TotalInterest_Text[2] + "/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView[2]"};
	public static final String[] TotalPayment_Text = {"xpath", "Total Payment Text", "//android.widget.TextView[@text = 'Total Payment']"};
	public static final String[] TotalPayment_Value = {"xpath", "Total Payment Value", TotalPayment_Text[2] + "/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView[2]"};
	
	public static final String[] Share_Button = {"id", "Share Button", "com.ajra.emicalculator:id/view_share_result_button"};
	public static final String[] Details_Button = {"id", "Details Button", "com.ajra.emicalculator:id/button_statistics"};
	
	public static final String[] Table_Yearly = {"xpath", "Table - Yearly", "//android.widget.TextView[@text = 'YEARLY']"};
	public static final String[] TY_YearNumber_Header = {"id", "Year Number - Yearly Table Header", "com.ajra.emicalculator:id/col_1"};
	public static final String[] TY_PrincipalPaid_Header = {"id", "Principal Paid - Yearly Table Header", "com.ajra.emicalculator:id/col_2"};
	public static final String[] TY_InterestPaid_Header = {"id", "Interest Paid - Yearly Table Header", "com.ajra.emicalculator:id/col_3"};
	public static final String[] TY_YearEndLoanBalance_Header = {"id", "Year End Loan Balance - Yearly Table Header", "com.ajra.emicalculator:id/col_4"};
	
	public static final String[] Table_Monthly = {"xpath", "Table - Monthly", "//android.widget.TextView[@text = 'MONTHLY']"};
	public static final String[] TM_YearNumber_Header = {"id", "Year Number - Monthly Table Header", "com.ajra.emicalculator:id/col_1"};
	public static final String[] TM_PrincipalPaid_Header = {"id", "Principal Paid - Monthly Table Header", "com.ajra.emicalculator:id/col_2"};
	public static final String[] TM_InterestPaid_Header = {"id", "Interest Paid - Monthly Table Header", "com.ajra.emicalculator:id/col_3"};
	public static final String[] TM_MonthEndLoanBalance_Header = {"id", "Month End Loan Balance - Monthly Table Header", "com.ajra.emicalculator:id/col_4"};
	
	public static final String[] Table_Graph = {"xpath", "Table - Graph", "//android.widget.TextView[@text = 'GRAPH']"};
	public static final String[] Graph_PieChart = {"id", "Graph - Pie Chart", "com.ajra.emicalculator:id/chart"};
}
