package br.com.bnck.cursocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

    @Given("Lucy is located {int} metres from Sean")
    public void lucy_is_located_metres_from_sean(Integer int1) {
    }

    @When("Sean shouts {string}")
    public void sean_shouts(String string) {
    }

    @Then("Lucy hears Sean's message")
    public void lucy_hears_sean_s_message() {
    }

}
