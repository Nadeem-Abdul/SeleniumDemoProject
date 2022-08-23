package resources;
import java.util.ArrayList;

import resources.Xls_Reader;

public class TestUtility {

	public static  ArrayList<Object[]> getTestDatafromExcel()
	{
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		Xls_Reader reader = new Xls_Reader("F:\\Eclipse\\NewjobE2EProject\\src\\main\\java\\resources\\Book1.xlsx");
		int size=reader.getRowCount("Sheet1");
		
		for(int rowNum=2;rowNum<=size;rowNum++)
		{
			String userName = reader.getCellData("Sheet1", "UserName", rowNum);
			String password =reader.getCellData("Sheet1", "Password", rowNum);
			Object [] ob= {userName,password};
			
			myData.add(ob);
			
		}
		return myData;
		
	}
	
	public static ArrayList<Object[]> getLoginTestDataFromExcel()
	{
		ArrayList<Object[]> loginTestData = new ArrayList<Object[]>();
		
		Xls_Reader reader= new Xls_Reader("D:\\Softwares\\Automation Testing\\HDFCAutomationTesting\\TestData\\HDFCLogin.xlsx");
		int size= reader.getRowCount("Sheet1");
		
		for(int rowNum=2;rowNum<=size;rowNum++)
		{
			String custID =reader.getCellData("Sheet1", "CustID", rowNum);
			
			String password = reader.getCellData("Sheet1", "Password", rowNum);
			Object[] ob= {custID,password};
			
			loginTestData.add(ob);
		}
		return loginTestData;
	}
	
	
	
	
}
