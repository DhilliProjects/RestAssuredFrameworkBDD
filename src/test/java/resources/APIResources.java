package resources;

//enum - is a special class in java which has a collection of constants or methods
public enum APIResources {

	//These are like the method names and arguments we provide - in enum class
	AddPlaceAPI("/maps/api/place/add/json"), //In enum, the method which accepts an argument looks like this.
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	
	private String resource;
	
	//This constructor is used to call for every method name we provide(like 	AddPlaceAPI("/maps/api/place/add/json") 
	//to load and pass to the local or class level variable we provided - and that can be called/returned with a method we created(like getResource()).
	APIResources(String resource) //Constructor to accept a parameter - just we need to create this - so that we can use the enum class in StepDefinition class
	{
		this.resource=resource; //asigning the variable ('resource' of the Constructor) to the local variable('resource' in the class).	
	}
	public String getResource()
	{
		return resource; //returning the 'private String resource' variable
	}
}
