package data;

import common.Utils;

public class TC01_ValidateVehicleLoanData extends Utils {
	
	static String excelFile = System.getProperty("user.dir").replace("\\", "/") + "/src/test/resources/Testdata/TestData.xlsx";
	static String workSheet = "VehicleLoan";
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
	
	public String getVehiclePrice() throws Exception{
		setExcelFile(excelFile, workSheet);
		return getCellData(Integer.parseInt(countScriptToString), 2);
	}
	
	public String getDownPaymentRequirement() throws Exception{
		setExcelFile(excelFile, workSheet);
		return getCellData(Integer.parseInt(countScriptToString), 3);
	}
	
	public String getDownPaymentAmount() throws Exception{
		setExcelFile(excelFile, workSheet);
		return getCellData(Integer.parseInt(countScriptToString), 4);
	}
	
	public String getAnnualInterstRate() throws Exception{
		setExcelFile(excelFile, workSheet);
		return getCellData(Integer.parseInt(countScriptToString), 5);
	}
	
	public String getLoanTerm() throws Exception{
		setExcelFile(excelFile, workSheet);
		return getCellData(Integer.parseInt(countScriptToString), 6);
	}
	
	public String getLoanDuration() throws Exception{
		setExcelFile(excelFile, workSheet);
		return getCellData(Integer.parseInt(countScriptToString), 7);
	}
	
	public String getMonthlyEMI() throws Exception{
		setExcelFile(excelFile, workSheet);
		return getCellData(Integer.parseInt(countScriptToString), 9);
	}
	
	public String getNumberOfPayments() throws Exception{
		setExcelFile(excelFile, workSheet);
		return getCellData(Integer.parseInt(countScriptToString), 10);
	}
	
	public String getTotalInterest() throws Exception{
		setExcelFile(excelFile, workSheet);
		return getCellData(Integer.parseInt(countScriptToString), 11);
	}
	
	public String getTotalPayment() throws Exception{
		setExcelFile(excelFile, workSheet);
		return getCellData(Integer.parseInt(countScriptToString), 12);
	}
	
}
