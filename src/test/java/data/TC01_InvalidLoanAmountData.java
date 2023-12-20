package data;

import common.Utils;

public class TC01_InvalidLoanAmountData extends Utils {
	
	static String excelFile = System.getProperty("user.dir").replace("\\", "/") + "/src/test/resources/Testdata/TestData.xlsx";
	static String workSheet = "InvalidLoanAmount";
	static String countScriptToString;
	
	public void getCounter() throws Exception {
		setExcelFile(excelFile, workSheet);
		countScriptToString = getCellData(2, 1);
	} 
	
	public void setCounter() throws Exception {
		setExcelFile(excelFile, workSheet);
		int count = Integer.parseInt(countScriptToString);
		count++;
		countScriptToString = Integer.toString(count);
		setCellData(2, 1, countScriptToString);
	}
	
	public void resetCounter() throws Exception{
		setExcelFile(excelFile, workSheet);
		setCellData(2, 1, "2");
	}
	
	public String getMonthlyPayment() throws Exception{
		setExcelFile(excelFile, workSheet);
		return getCellData(Integer.parseInt(countScriptToString), 2);
	}
	
	public String getAnnualInterestRate() throws Exception{
		setExcelFile(excelFile, workSheet);
		return getCellData(Integer.parseInt(countScriptToString), 3);
	}
	
	public String getLoanTerm() throws Exception{
		setExcelFile(excelFile, workSheet);
		return getCellData(Integer.parseInt(countScriptToString), 4);
	}
	
	public String getLoanDuration() throws Exception{
		setExcelFile(excelFile, workSheet);
		return getCellData(Integer.parseInt(countScriptToString), 5);
	}
}
