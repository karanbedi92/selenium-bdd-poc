package com.cts.step.definitions;

import cucumber.api.java.en.*;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.cts.coe.pages.ApplicationLoginPage;
import cucumber.api.PendingException;

public class GlobalStepDefinitions extends ApplicationLoginPage {
	@Given("^I am on the \"([^\"]*)\" page on URL \"([^\"]*)\"$")
	public void loginApplication(String company, String site) throws Throwable {
		System.out.println(company + " : " + site);

		launchApplication();
		loginApplication();
		closeApplication();
	}

	@When("^I fill in \"([^\"]*)\" with \"([^\"]*)\"$")
	public void i_fill_in_with(String arg1, String arg2) throws Throwable {

	}

	@When("^I click on the \"([^\"]*)\" button$")
	public void i_click_on_the_button(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("^I should see \"([^\"]*)\" message$")
	public void i_should_see_message(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("^I should see the \"([^\"]*)\" button$")
	public void i_should_see_the_button(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@Given("^you are in Given annotation$")
	public void given() throws Throwable {

	}

	@When("^you are in When annotation$")
	public void when() throws Throwable {
	}

	@Then("^you are in Then annotation$")
	public void then() throws Throwable {
	}

	@And("^you are in And annotation$")
	public void and() throws Throwable {
	}

	@But("^you are in But annotation$")
	public void but() throws Throwable {
	}

	/**
	 * 
	 * @param url
	 * @throws Throwable
	 */
	@Given("^I am on the home page with  URL \"([^\"]*)\"$")
	public void i_am_on_the_home_page_with_URL(String url) throws Throwable {

		driver = getWebDriverInstance(url);
//		driver.get("http://172.18.0.22:8080/petclinic/");
		driver.get("http://172.17.0.2:8080/petclinic/");
		takeSnapShot(driver, new Random().nextInt(1000) + ""+"image.png");
	}

	@Then("^I should see Home Page$")
	public void i_should_see_Home_Page() throws Throwable {
		String homeLabel = driver.findElement(By.xpath("//*[text()='Home']")).getText();
		Assert.assertEquals("HOME", homeLabel);
		takeSnapShot(driver, new Random().nextInt(1000) + ""+"image.png");

	}

	@When("^I Navigate to  Add Owner$")
	public void i_Navigate_to_Add_Owner() throws Throwable {
		driver.findElement(By.xpath("//*[text()='Find owners']")).click();
		driver.findElement(By.linkText("Add Owner")).click();
		Thread.sleep(1000);
		takeSnapShot(driver, new Random().nextInt(1000) + ""+"image.png");

	}

	@When("^I fill in First Name \"([^\"]*)\"$")
	public void i_fill_in_First_Name(String arg1) throws Throwable {

		WebElement element = driver.findElement(By.xpath("//input[@name='firstName']"));
		element.clear();
		element.sendKeys(arg1);
		takeSnapShot(driver, new Random().nextInt(1000) + ""+"image.png");

	}

	@When("^I fill in Last Name \"([^\"]*)\"$")
	public void i_fill_in_Last_Name(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.xpath("//input[@name='lastName']"));
		element.clear();
		element.sendKeys(arg1);
		takeSnapShot(driver, new Random().nextInt(1000) + ""+"image.png");

	}

	@When("^I fill in Address \"([^\"]*)\"$")
	public void i_fill_in_Address(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.xpath("//input[@name='address']"));
		element.clear();
		element.sendKeys(arg1);
		takeSnapShot(driver, new Random().nextInt(1000) + ""+"image.png");

	}

	@When("^I fill in City \"([^\"]*)\"$")
	public void i_fill_in_City(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.xpath("//input[@name='city']"));
		element.clear();
		element.sendKeys(arg1);
		takeSnapShot(driver, new Random().nextInt(1000) + ""+"image.png");

	}

	@When("^I fill in Telephone \"([^\"]*)\"$")
	public void i_fill_in_Telephone(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.xpath("//input[@name='telephone']"));
		element.clear();
		element.sendKeys(arg1);
		Thread.sleep(1000);
	}

	@When("^I click on Add Owner$")
	public void i_click_on_Add_Owner() throws Throwable {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
	}

	@Then("^I should see owner information added with Telephone \"([^\"]*)\"$")
	public void i_should_see_owner_information_added_with_Telephone(String arg1) throws Throwable {
		boolean isTelphoneDisplayed = driver.findElement(By.xpath("//*[text()='" + arg1 + "']")).isDisplayed();
		Assert.assertEquals(isTelphoneDisplayed, true);
		Thread.sleep(1000);
		closeApplication();
	}

	@When("^I Navigate to  Search Owner$")
	public void i_Navigate_to_Search_Owner() throws Throwable {
		driver.findElement(By.xpath("//*[text()='Find owners']")).click();

	}

	@When("^I click on Find Owner$")
	public void i_click_on_Find_Owner() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Find Owner']")).click();
	}

	@When("^I click  on name \"([^\"]*)\"$")
	public void i_click_on_name(String arg1) throws Throwable {
		driver.findElement(By.xpath("//*[text()='" + arg1 + "']")).click();
		Thread.sleep(1000);
	}

	@When("^click on Edit Owner$")
	public void click_on_Edit_Owner() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Edit Owner']")).click();
	}

	@When("^I cick on Add new Pet$")
	public void i_cick_on_Add_new_Pet() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Add New Pet']")).click();
	}

	@When("^Enter pet name \"([^\"]*)\"$")
	public void enter_pet_name(String arg1) throws Throwable {
		String randomStr = new Random().nextInt(1000) + "";
		System.out.println(randomStr);
		WebElement element = driver.findElement(By.id("name"));
		element.clear();
		element.sendKeys(arg1 + randomStr);

	}

	@When("^Select Birthdate \"([^\"]*)\"$")
	public void select_Birthdate(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.id("birthDate"));
		element.clear();
		element.sendKeys(arg1);
		element.sendKeys("\n");

	}

	@When("^Select Pet type \"([^\"]*)\"$")
	public void select_Pet_type(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.id("type"));
		Select select = new Select(element);
		select.selectByVisibleText(arg1);
	}

	@When("^Click on Add Pet$")
	public void click_on_Add_Pet() throws Throwable {

		WebElement element = driver.findElement(By.xpath("//button[@type='submit']"));
		System.out.println(element.isDisplayed());
		System.out.println(element.isEnabled());
		System.out.println(element.isSelected());
		element.click();

	}

	@Then("^I should see the pet added in  the list$")
	public void i_should_see_the_pet_added_in_the_list() throws Throwable {
		closeApplication();
	}

	@When("^I click  on name Add visit$")
	public void i_click_on_name_Add_visit() throws Throwable {
		driver.findElements(By.xpath("//a[text()='Add Visit']")).get(0).click();

	}

	@When("^Select Date as \"([^\"]*)\"$")
	public void select_Date_as(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.id("date"));
		element.clear();
		element.sendKeys(arg1);
		element.sendKeys("\n");
	}

	@When("^Put description as \"([^\"]*)\"$")
	public void put_description_as(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.id("description"));
		element.sendKeys(arg1);
	}

	@When("^Click on Add visit$")
	public void click_on_Add_visit() throws Throwable {
		WebElement element = driver.findElement(By.xpath("//button[@type='submit']"));
		Thread.sleep(100);
		element.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		closeApplication();
	}

	
}
