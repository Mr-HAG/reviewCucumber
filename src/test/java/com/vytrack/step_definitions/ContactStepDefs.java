package com.vytrack.step_definitions;

import com.vytrack.Pages.DashboardPage;
import com.vytrack.Pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ContactStepDefs {

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        //go to login page
        Driver.get().get(ConfigurationReader.get("url"));
        //based on input enter that user information
        String username = null;
        String password = null;

        if(userType.equals("driver")){
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        }else if(userType.equals("sales manager")){
            username = ConfigurationReader.get("sales_manager_username");
           password = ConfigurationReader.get("sales_manager_password");
        }else if (userType.equals("store manager")){
            username = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");
        }

        //send username and password
        new LoginPage().login(username,password);

    }
    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> menuOptions) {
        System.out.println(menuOptions.size());
        System.out.println(menuOptions);
        BrowserUtils.waitFor(2);
        //get the list of the WebElement and convert it to list of string with the help of ready method
        List<String> actualList = BrowserUtils.getElementsText(new DashboardPage().menuOptions);
        Assert.assertEquals(menuOptions,actualList);

    }


    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String,String> userInfo) {
        System.out.println(userInfo);
        LoginPage loginPage = new LoginPage();
        loginPage.login(userInfo.get("username"), userInfo.get("password"));

        String expectedName = (userInfo.get("firstname") + " " +userInfo.get("lastname"));
        String actualName = new DashboardPage().getUserName();

        Assert.assertEquals(expectedName,actualName);

    }
}
