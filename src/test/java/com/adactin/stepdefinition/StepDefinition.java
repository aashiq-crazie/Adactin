package com.adactin.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.adactin.helper.ConfigurationReader;
import com.adactin.helper.FileReaderManager;
import com.adactin.helper.PageObjectManager;
import com.adactin.pom.BookItenaryPage;
import com.adactin.pom.BookingConfirmPage;
import com.adactin.pom.BookingHotelpage;
import com.adactin.pom.CancelHotelpage;
import com.adactin.pom.LogOutPage;
import com.adactin.pom.SearchHotelPage;
import com.adactin.pom.SelectHotelPage;
import com.adactin.pom.SignInPage;
import com.adactin.runner.Runner;
import com.baseclass.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDefinition extends BaseClass {

	public static WebDriver driver = Runner.driver;
	PageObjectManager pom = new PageObjectManager(driver);

	@Given("^the user is logged in$")
	public void the_user_is_logged_in() throws Throwable {
		System.out.println("LoggedIn");
	}

	@Given("^goes to landing page$")
	public void goes_to_landing_page() throws Throwable {
		System.out.println("Landing Pages");
	}

	@Given("^User launch the adactin application$")
	public void user_launch_the_adactin_application() throws Throwable {
		String Url = FileReaderManager.getInstance().getCRInstance().getUrl();
		getUrl(Url);
	}

	@When("^User enter the valid username$")
	public void user_enter_the_valid_username() throws Throwable {
		String userName = FileReaderManager.getInstance().getTDInstance().testMeth("User Name");
		sendKeys(pom.getSip().getUsername(), userName);
	}

	@When("^User enter the valid password$")
	public void user_enter_the_valid_password() throws Throwable {
		String password = FileReaderManager.getInstance().getTDInstance().testMeth("Password");
		sendKeys(pom.getSip().getPassword(), password);
	}

	/*
	 * @When("^User enter the \"([^\"]*)\" valid username$") public void
	 * user_enter_the_valid_username(String username) throws Throwable {
	 * sendKeys(pom.getSip().getUsername(), username); }
	 * 
	 * @When("^User enter the \"([^\"]*)\" valid password$") public void
	 * user_enter_the_valid_password(String password) throws Throwable {
	 * sendKeys(pom.getSip().getPassword(), password); }
	 */

	@When("^User enter the login button$")
	public void user_enter_the_login_button() throws Throwable {
		clickMethod(pom.getSip().getLogin());
	}

	@Then("^It lands to the homepage successfully$")
	public void it_lands_to_the_homepage_successfully() throws Throwable {
		System.out.println("Navigate homepage sucessfully");
	}

	@Given("^User select the required location$")
	public void user_select_the_required_location() throws Throwable {
		String location = FileReaderManager.getInstance().getTDInstance().testMeth("Location");
		dropDownMeth(pom.getShp().getLocation(), "value", location);
	}

	@When("^User select the number of rooms$")
	public void user_select_the_number_of_rooms() throws Throwable {
		String rooms = FileReaderManager.getInstance().getTDInstance().testMeth("Number of Rooms");
		dropDownMeth(pom.getShp().getRoom(), "value", rooms);
	}

	@When("^User mentioning checkin date$")
	public void user_mentioning_checkin_date() throws Throwable {
		String cIDate = FileReaderManager.getInstance().getTDInstance().testMeth("Check In Date");
		sendKeys(pom.getShp().getCheckInDate(), cIDate);
	}

	@When("^User mentioning checkout date$")
	public void user_mentioning_checkout_date() throws Throwable {
		String cODate = FileReaderManager.getInstance().getTDInstance().testMeth("Check Out Date");
		sendKeys(pom.getShp().getCheckOutDate(), cODate);
	}

	@When("^User selecting adults per room$")
	public void user_selecting_adults_per_room() throws Throwable {
		String adultRoom = FileReaderManager.getInstance().getTDInstance().testMeth("Adults per Room");
		dropDownMeth(pom.getShp().getAdultsPerRoom(), "value", adultRoom);
	}

	@When("^User enter the search button$")
	public void user_enter_the_search_button() throws Throwable {
		clickMethod(pom.getShp().getSearchId());
	}

	@Then("^It lands to the nextpage succesfully$")
	public void it_lands_to_the_nextpage_succesfully() throws Throwable {
		System.out.println("Navigating nextpage succesfully");
	}

	@Given("^User select his favourite hotel$")
	public void user_select_his_favourite_hotel() throws Throwable {
		clickMethod(pom.getSehp().getRadioButton());
	}

	@When("^User enter the continue button$")
	public void user_enter_the_continue_button() throws Throwable {
		clickMethod(pom.getSehp().getContinueButton());
	}

	@Given("^User mentioning firstname$")
	public void user_mentioning_firstname() throws Throwable {
		String firstName = FileReaderManager.getInstance().getTDInstance().testMeth("First Name");
		sendKeys(pom.getBhp().getFirstName(), firstName);
	}

	@When("^User mentioning lastname$")
	public void user_mentioning_lastname() throws Throwable {
		String lastName = FileReaderManager.getInstance().getTDInstance().testMeth("Last Name");
		sendKeys(pom.getBhp().getLastName(), lastName);
	}

	/*
	 * @Given("^User mentioning \"([^\"]*)\" firstname$") public void
	 * user_mentioning_firstname(String firstname) throws Throwable {
	 * sendKeys(pom.getBhp().getFirstName(), firstname); }
	 * 
	 * @When("^User mentioning \"([^\"]*)\" lastname$") public void
	 * user_mentioning_lastname(String lastname) throws Throwable {
	 * sendKeys(pom.getBhp().getLastName(), lastname); }
	 */
	@When("^User mentioning billing address$")
	public void user_mentioning_billing_address() throws Throwable {
		String address = FileReaderManager.getInstance().getTDInstance().testMeth("Billing Address");
		sendKeys(pom.getBhp().getAddress(), address);
	}

	@When("^User mentioning creditcard number$")
	public void user_mentioning_creditcard_number() throws Throwable {
		String creditNumber = FileReaderManager.getInstance().getTDInstance().testMeth("Credit Card No.");
		sendKeys(pom.getBhp().getCardNumber(), creditNumber);
	}

	@When("^User selecting creditcard type$")
	public void user_selecting_creditcard_type() throws Throwable {
		String creditType = FileReaderManager.getInstance().getTDInstance().testMeth("Credit Card Type");
		dropDownMeth(pom.getBhp().getCardType(), "value", creditType);
	}

	@When("^User mentioning month of expiry$")
	public void user_mentioning_month_of_expiry() throws Throwable {
		String expiryMonth = FileReaderManager.getInstance().getTDInstance().testMeth("Expiry Month");
		dropDownMeth(pom.getBhp().getExpMonth(), "value", expiryMonth);
	}

	@When("^user mentioning year of expiry$")
	public void user_mentioning_year_of_expiry() throws Throwable {
		String expiryYear = FileReaderManager.getInstance().getTDInstance().testMeth("Expiry Year");
		dropDownMeth(pom.getBhp().getExpYear(), "value", expiryYear);
	}

	@When("^User mentioning the cvv number$")
	public void user_mentioning_the_cvv_number() throws Throwable {
		String cvvNumber = FileReaderManager.getInstance().getTDInstance().testMeth("CVV Number");
		sendKeys(pom.getBhp().getCvvNumber(), cvvNumber);
	}

	@When("^User enter the booknow button$")
	public void user_enter_the_booknow_button() throws Throwable {
		clickMethod(pom.getBhp().getBooknowButton());

	}

	@Then("^It lands to nextpage succesfully$")
	public void it_lands_to_nextpage_succesfully() throws Throwable {
		System.out.println("Sussecfully loads to next page");
	}

	@Given("^User enter the myitenary button$")
	public void user_enter_the_myitenary_button() throws Throwable {
		clickMethod(pom.getBcp().getItenaryButton());
	}

	@Given("^User selecting reqiured hotel to cancel$")
	public void user_selecting_reqiured_hotel_to_cancel() throws Throwable {
		clickMethod(pom.getBip().getRadioButton());
	}

	@Given("^User enter the cancel button$")
	public void user_enter_the_cancel_button() throws Throwable {
		// clickMethod(pom.getChp().getCancelButton());
	}

	@When("^user confirming the cancellation$")
	public void user_confirming_the_cancellation() throws Throwable {
		simpleAlert();
	}

	@Then("^It loads to nextpage succesfully$")
	public void it_loads_to_nextpage_succesfully() throws Throwable {
		System.out.println("Succesfully loaded to nextpage");

	}

	@Given("^User enter the logoutbutton$")
	public void user_enter_the_logoutbutton() throws Throwable {
		clickMethod(pom.getLop().getLogout());
	}

	@Then("^It loads to final page succefully$")
	public void it_loads_to_final_page_succefully() throws Throwable {
	}

}
