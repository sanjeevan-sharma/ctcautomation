package ctc1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ctc1 {
	
	

	public static void main(String[] args) throws IOException {
		Ctc1 obj = new Ctc1();
	//	obj.signup();
		obj.login();
	}
	
	
	public void signup() throws IOException
{
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    
		try
		{
		
		// Open the Excel file

		FileInputStream ExcelFile = new FileInputStream("D:/CTC.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFile); 
		XSSFSheet sheet = wb.getSheet("Sheet1");
			
		for(int i=6;i<9;i++)
		{
			
			driver.get("http://ec2-34-211-212-179.us-west-2.compute.amazonaws.com/");
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id='wrap']/main/div[1]/div[1]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='wrap']/main/div[4]/div/div/div/div[3]/form/div[4]/div[2]/a")).click();
		
			String uuid = UUID.randomUUID().toString();
			XSSFRow row = sheet.getRow(i);
		    String username = row.getCell(0).getStringCellValue();
		    String email = row.getCell(1).getStringCellValue();
			Thread.sleep(2000);
			
		    //Signup
		    
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(uuid);
		driver.findElement(By.xpath("//*[@id='password-confirm']")).sendKeys(uuid);
		driver.findElement(By.name("terms")).click();
		driver.findElement(By.xpath("//*[@id='wrap']/main/div[4]/div/div/div[2]/form/div[6]/div[1]/button")).click();
        System.out.println("user with email id :-"+email+"has been created successfully");
		Thread.sleep(2000);

		//Logout
		driver.findElement(By.xpath("//*[@id='wrap']/main/div[1]/div[1]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id='wrap']/main/div[1]/div[1]/ul/li[2]/div/a[3]")).click();
        System.out.println("user with email id :-"+email+"has log out successfully");

		Thread.sleep(2000);

		
		
		 XSSFCell cell=row.getCell(2);

			cell.setCellValue(uuid.toString());

			
		 FileOutputStream fileOut = new FileOutputStream("D:/CTC.xlsx");
         wb.write(fileOut);
         fileOut.flush();
         fileOut.close();
         System.out.println("Password added to excel sheet");
		}
 		driver.close();

	}

		catch(Exception e)
		{
			System.out.println(e);
		}
}

	
	
	public void login() throws IOException
	{

		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		try
		{		
		// Open the Excel file
		FileInputStream ExcelFile = new FileInputStream("D:/CTC.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFile); 
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		for(int i=1;i<6;i++)
		{
			driver.get("http://ec2-34-211-212-179.us-west-2.compute.amazonaws.com/");
			Thread.sleep(2000);

			//Sign-in
			XSSFRow row = sheet.getRow(i);
		    String email = row.getCell(1).getStringCellValue();
		    String password =row.getCell(2).getStringCellValue();
		    
			driver.findElement(By.xpath("//*[@id='wrap']/main/div[1]/div[1]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='email']")).sendKeys(email);
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
			driver.findElement(By.xpath("//*[@id='wrap']/main/div[4]/div/div/div/div[3]/form/div[4]/div[1]/button")).click();
	        System.out.println("user with email id :- "+email+ " login successfully");

			Thread.sleep(2000);

			//logout
			driver.findElement(By.xpath("//*[@id='wrap']/main/div[1]/div[1]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='wrap']/main/div[1]/div[1]/ul/li[2]/div/a[3]")).click();
	        System.out.println("user with email id :- "+email+" has log out successfully");

		}
		driver.close();

	}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	
}
