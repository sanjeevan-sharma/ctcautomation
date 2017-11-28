package ctc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ctc_basic {

	public static void main(String[] args) throws IOException {
		
	    FileInputStream ExcelFile = new FileInputStream("D:/CTC.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFile); 
		XSSFSheet sheet = wb.getSheet("Sheet1");
		String uuid = "hello123";


		//String uuid = UUID.randomUUID().toString();
		XSSFRow row = sheet.getRow(1);
		//System.out.println(row.toString());

		// XSSFCell cell=null;
		 XSSFCell cell=row.getCell(0);
		// cell.getStringCellValue();

		cell.setCellValue(uuid.toString());

		

		 FileOutputStream fileOut = new FileOutputStream("D:/CTC.xlsx");
        wb.write(fileOut);
        fileOut.flush();
        fileOut.close();
		
		
		}

}
