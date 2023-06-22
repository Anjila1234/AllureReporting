package allureReport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class allurepractice {
WebDriver driver;


@BeforeClass
public void setup() {
	driver = new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
	driver.findElement(By.xpath("//input[@type='submit']")).submit();
}
@Test(priority = 1, description ="verify logo")
@Description ("verify logo in home page")
@Epic("EP001")
@Feature("Feature1 : sauce")
@Story("story:logo presence")
@Step("verify logo presence")
@Severity(SeverityLevel.MINOR)
public void onepresence() {

String actual = driver.findElement(By.cssSelector("div[class='app_logo']")).getText();
Assert.assertEquals(actual, "Swag Labs");
}

@Test(priority = 2)

@Description ("verify add to cart")
@Epic("EP002")
@Feature("Feature2 : sauce")
@Story("story:add to cart")
@Step("verify cart")
@Severity(SeverityLevel.BLOCKER)
public void Twopresence() {
	String actual1 = driver.findElement(By.cssSelector("button[id=\"add-to-cart-sauce-labs-backpack\"]")).getText();
Assert.assertEquals(actual1, "Add to cart");

}
@Test(priority = -2)
public void  minuspresence() {
	driver.findElement(By.cssSelector("a[class='shopping_cart_link']")).click();
	
}
@Test(priority = 0)
public void zeropresence() {
	driver.findElement(By.id("checkout")).click();
}
@Test
public void defaultpresence() {
	System.out.println("Test case passed");
}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}

