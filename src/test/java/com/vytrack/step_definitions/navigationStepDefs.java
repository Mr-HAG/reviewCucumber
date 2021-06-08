package com.vytrack.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class navigationStepDefs {


    @When("Navigate from Fleet to Vehicle")
    public void navigate_from_fleet_to_vehicle() {
        System.out.println("the user navigates from fleets to vehicle");
    }

    @When("Navigate from Marketing to Campaigns")
    public void navigate_from_marketing_to_campaigns() {
        System.out.println("the user navigates from marketing to campaigns");
    }

    @When("Navigate from Activities to Calender Events")
    public void navigate_from_activities_to_calender_events() {
        System.out.println("the user navigates from activities to calender events");
    }

    @Then("Title should be Vehicle")
    public void title_should_be_vehicle() {
        System.out.println("expected and actual titles are matching");
    }

    @Then("Title should be Campaigns")
    public void title_should_be_campaigns() {
        System.out.println("expected and actual titles are matching");
    }

    @Then("Title should be Calenders")
    public void title_should_be_calenders() {
        System.out.println("expected and actual titles are matching");
    }



}
