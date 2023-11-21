package pageLocators;

public class LoanAmountPage {
	
	public static final String[] LoanAmount_Title = {"id", "Loan Amount Title", "com.ajra.emicalculator:id/text_title"};
	
	public static final String[] MonthlyRepayment_Textbox = {"id", "Monthly Repayment Textbox", "com.ajra.emicalculator:id/control_principal_amount"};
	public static final String[] AnnualInterestRate_Textbox = {"id", "Annual Interest Rate Textbox", "com.ajra.emicalculator:id/control_rate_of_interest"};
	public static final String[] LoanTerm_Textbox = {"id", "Loan Term Textbox", "com.ajra.emicalculator:id/controlInvestmentPeriod"};
	public static final String[] LoanTerm_Dropdown = {"id", "Loan Term Dropdown", "android:id/text1"};
	public static final String[] LoanTerm_Dropdown_Years = {"xpath", "Loan Terms - Years", "//android.widget.TextView[@text = 'Years']"};
	public static final String[] LoanTerm_Dropdown_Months = {"xpath", "Loan Terms - Months", "//android.widget.TextView[@text = 'Months']"};
	
	public static final String[] Clear_Button = {"id", "Clear Button", "com.ajra.emicalculator:id/button_reset"};
	public static final String[] Calculate_Button = {"id", "Calculate Button", "com.ajra.emicalculator:id/button_calculate"};
	
	public static final String[] Result_Header = {"xpath", "Result Header", "//android.widget.TextView[@text = 'Result']"};
	
	public static final String[] LoanAmount_Text = {"xpath", "Loan Amount Text", "(//android.widget.TextView[@text = 'Loan Amount'])[2]"};
	public static final String[] LoanAmount_Value = {"xpath", "Loan Amount Value", LoanAmount_Text[2] + "/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView[2]"};
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
