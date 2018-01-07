package com.AdidasTask.cucumber.steps;

import com.AdidasTask.cucumber.methods.AdidasTaskMethods;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdidasQATaskSteps extends AdidasTaskMethods {

	@When("^User sends a GET request to the list endpoint, they must get back a valid status code (\\d+)$")
	public void user_sends_a_GET_request_to_the_list_endpoint_they_must_get_back_a_valid_status_code(int arg1)
			throws Throwable {
		Verify_status_Code();

	}

	@When("^User sends a request to check the reponse time, Response time is below 1s$")
	public void user_sends_a_request_to_check_the_reponse_time_Response_time_is_below_1s() throws Throwable {
		testResponsTime();
	}

	@When("^User gets all the urls$")
	public void user_gets_all_the_urls() throws Throwable {
		GetUrls();
	}

	@Then("^all the images are accessible$")
	public void all_the_images_are_accessible() throws Throwable {
		Check_Response_Code();
	}

	@When("^User gets all the compenents$")
	public void user_gets_all_the_compenents() throws Throwable {
		GetAllComponents();
	}


	@Then("^component has analyAcs data: analytics_name in it$")
	public void component_has_analyAcs_data_analytics_name_in_it() throws Throwable {
		Check_Analytics_Data();
	}
}
