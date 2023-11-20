package pageLocators;

public class HomePage {
	public static final String[] Title = {"id", "Title", "com.ajra.emicalculator:id/text_title"};
	
	public static final String[] LoanAndEmi_Header = {"id", "Loan And EMI Header", "com.ajra.emicalculator:id/cat_emi_view"};
	public static final String[] LoanAndEmi_Collapse = {"id", "Loan And EMI Collapse Icon", "com.ajra.emicalculator:id/cat_emi_img"};
	public static final String[] LoanAndEmi_ChildElements = {"xpath", "Loan And EMI Child Elements", "//android.widget.LinearLayout[@resource-id = 'com.ajra.emicalculator:id/emi_container']//android.widget.TextView"};
	
	public static final String[] LAE_LoanBasic_Text = {"xpath", "Loan Basic Text", "//android.widget.TextView[@text = 'Loan Basic']"};
	public static final String[] LAE_LoanAdvance_Text = {"xpath", "Loan Advance Text", "//android.widget.TextView[@text = 'Loan Advance']"};
	public static final String[] LAE_CompareLoan_Text = {"xpath", "Compare Loan Text", "//android.widget.TextView[@text = 'Compare Loan']"};
	public static final String[] LAE_LoanAmountEligibility_Text = {"xpath", "Loan Amount Eligibility", "//android.widget.TextView[@text = 'Loan Amount Eligibility']"};
	public static final String[] LAE_HomeLoanDocuments_Text = {"xpath", "Home Loan Documents", "//android.widget.TextView[@text = 'Home Loan Documents']"};
	
}
