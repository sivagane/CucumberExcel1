package org.StepDefinition;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks  {
public static WebDriver d; 	
@Before
public void beforeScenario() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\jegan\\eclipse-workspace\\CucumberExcel1\\div\\chromedriver.exe");
    d=new ChromeDriver();
    
    }
@After
public void afterScenario() {
	
}
}

