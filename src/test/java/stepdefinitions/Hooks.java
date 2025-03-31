package stepdefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	//Cucumber now understands that - before executing the scenario tagged with '@DeletePlace', it should first run this method here.
	@Before("@DeletePlace") //import the hook from io.cucumber
	public void beforeScenario() throws IOException
	{
		//Here we are writing a code that will give us the place_id (which we get from the AddPlace response usually)
		//Because, without place_id, DeletePlaceAPI won't work - because we are giving the body having place_id to delete the place_id
		//So, if we want to run only '@DeletePlace' scenario, we should use the Hooks
		
		//For, that what we are providing here is - 'Execute this code only when place_is is null' 
		//Because, we need to run the @DeletePlace scenario independently without depending on AddPlace scenario
		//So, here we are directly calling the required methods to do the function/to get our job done.
		
		StepDefinitions sd = new StepDefinitions();
		
		if(StepDefinitions.place_id==null) //it is recommended to call the static variables with class name
		{
			//This is the data/strings will be taken instead of data in Feature file.
			//Check in 'logging.txt' file by adding and removing the tags in TestRunner' class
		sd.add_place_payload_with("Jack", "Telugu", "India"); 
		sd.user_calls_with_http_request("AddPlaceAPI", "POST");
		sd.verify_place_id_created_maps_to_using("Jack", "GetPlaceAPI"); //As, we are using the method, we need provide some parameters accorsdingly
		}
	}
}
