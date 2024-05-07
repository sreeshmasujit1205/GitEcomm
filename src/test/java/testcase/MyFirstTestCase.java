package testcase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class MyFirstTestCase extends BaseTest{

	@Test(dataProvider="testdata")
	public static void Login(String mobnumber, String otp) throws InterruptedException {
		
		System.out.println("Test Case 1");
		driver.findElement(By.xpath(loc.getProperty("mobnum"))).sendKeys(mobnumber);
		driver.findElement(By.xpath(loc.getProperty("nextbutton"))).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List <WebElement> otpvalues= driver.findElements(By.xpath(loc.getProperty("otpvalues")));
		//otpvalue1.sendKeys("0");
		
		
		String value=otp;
		int i=0;
		for (WebElement e: otpvalues) {
			
			e.sendKeys(String.valueOf(value.charAt(i)));
			i++;
			}
		
		driver.findElement(By.xpath(loc.getProperty("submit"))).click();
		System.out.println("Welcome to HippoStores");
	}

	@DataProvider(name="testdata")
	public Object[][] tData(){
		
		return new Object[][] {
			
			{"9096219600","000000"},
			{"9820806229","000000"},
			{"9595998326","123456"},
		};
	}

	}


