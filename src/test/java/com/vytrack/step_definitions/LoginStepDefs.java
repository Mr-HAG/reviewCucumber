package com.vytrack.step_definitions;

import com.vytrack.Pages.ContactsPage;
import com.vytrack.Pages.DashboardPage;
import com.vytrack.Pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        //WebDriver driver = Driver.get();
        //driver.get(url);
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }
    @When("the user enter the driver information")
    public void the_user_enter_the_driver_information() {
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        LoginPage login = new LoginPage();
        login.login(username,password);
    }
    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        String actual = Driver.get().getTitle();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals("Verify title","Dashboard",actual);
    }

    @When("the user enter sales manager info")
    public void the_user_enter_sales_manager_info() {
        String username = ConfigurationReader.get("sales_manager_username");
        String password = ConfigurationReader.get("sales_manager_password");
        LoginPage login = new LoginPage();
        login.login(username,password);
    }

    @When("the user enter store manager info")
    public void the_user_enter_store_manager_info() {
        String username = ConfigurationReader.get("store_manager_username");
        String password = ConfigurationReader.get("store_manager_password");
        LoginPage login = new LoginPage();
        login.login(username,password);
   }


    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

    }

    @Then("Title should contain {string}")
    public void title_should_contain(String expectedTitle) {
         BrowserUtils.waitFor(2);
         String actualTitle = Driver.get().getTitle();
         Assert.assertTrue(actualTitle.contains(expectedTitle));
        System.out.println("actual title: " + actualTitle);
        System.out.println("expected title: " + expectedTitle);
         System.out.println("title verified");

    }

    @When("the user navigates {string} {string}")
    public void the_user_navigates(String tab, String module) {
        new DashboardPage().navigateToModule(tab,module);
    }
    @Then("default page number should be {int}")
    public void default_page_number_should_be(Integer int1) {
        ContactsPage contactsPage = new ContactsPage();
        BrowserUtils.waitFor(5);
        Integer actual = Integer.parseInt((contactsPage.pageNumber.getAttribute("value")));
        Assert.assertEquals(int1,actual);

    }
}
