package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	public AddPlace addPlacePayload(String name, String language, String address)
	{
	AddPlace ap = new AddPlace(); //Creating object for 'AddPlace' class to call the methods inside in it
	ap.setAccuracy(50);
	ap.setAddress(address);
	ap.setLanguage(language);
	ap.setPhone_number("9876543411");
	ap.setWebsite("https://dhilliprojects.com");
	ap.setName(name);
	
	List<String> myList = new ArrayList<String>(); //Created an ArrayList object to add String elements
	//and hence, we provided the variable type as List<String> in the 'AddPlace' class
	myList.add("park");
	myList.add("shopping");
	ap.setTypes(myList);
	
	//Another Nested Json
	Location l = new Location(); //Creating object for 'Location' class to call the methods in it
	l.setLat(-33.2522); //setting the values
	l.setLng(34.5627);
	
	ap.setLocation(l); 
	
	return ap;
}
	public String deletePlacePayload(String place_id)
	{
		return "{\"place_id\":\""+place_id+"\"}"; //you can convert the json payload to java string format in online
	}
}
