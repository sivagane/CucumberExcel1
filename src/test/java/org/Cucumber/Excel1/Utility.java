package org.Cucumber.Excel1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.StepDefinition.Hooks;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utility   {
public static List<HashMap<String,String>> read() throws IOException {
	List<HashMap<String,String>>li=new LinkedList<HashMap<String,String>>();
    File f=new File("C:\\Users\\jegan\\eclipse-workspace\\CucumberExcel1\\Excel\\siva1.xlsx");
    FileInputStream stream=new FileInputStream(f);
    Workbook w=new XSSFWorkbook(stream);
    Sheet s = w.getSheet("siva1");
    Row HeadRow = s.getRow(0);
    
    for(int i=1;i<s.getPhysicalNumberOfRows();i++) {
    	Row r = s.getRow(i);
    	HashMap<String,String>mp=new HashMap<String,String>();
    	for(int j=0;j<r.getPhysicalNumberOfCells();j++) {
    		Cell c = r.getCell(j);
    		int ct = c.getCellType();
    		if(ct==1) {
    		   String name = c.getStringCellValue();
    		   mp.put(HeadRow.getCell(j).getStringCellValue(), name);
    		}
    		else {
    			double d = c.getNumericCellValue();
    			long l=(long)d;
    			String name = String.valueOf(l);
    			mp.put(HeadRow.getCell(j).getStringCellValue(), name);
    		}
    		}
    	li.add(mp);
    	}
    return li; 
}
public static void launch(String s) {
	Hooks.d.get(s);
	String title = Hooks.d.getTitle();
	System.out.println(title);
}
public static void fill(WebElement w,String s) {
	w.sendKeys(s);
}
public static void klik(WebElement w) {
	w.click();
}


}
