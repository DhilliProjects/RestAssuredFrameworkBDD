package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

//Here, we'll place all the reusable methods

//Note: 'Properties' class in Java is used for managing a set of key-value pairs. 
		//These pairs are typically strings and are commonly used for configuration settings, storing data like application settings, database configurations, or any other type of property-like information. 
		//It extends the Hashtable class and provides additional support for loading and saving properties from/to files.
		//Advantages of Properties Class:
		//Simplifies handling configuration files.
		//Provides built-in support for reading and writing .properties files.
		//Easy integration with other Java utilities like InputStream and OutputStream.
		//Supports hierarchical defaults.

public class Utils {

	public static RequestSpecification requestSpec; //made static to use this single instance in entire execution
	ResponseSpecification responseSpec;
	
	public RequestSpecification requestSpecification() throws IOException
	{
		//When we are running the same test with multiple sets of data, the requestSpecification() method also runs those many times wrt the sets of data
		//So, when running again, only the latest request and responses are being stored in the logging.txt but not all data
		//Hence, to get the data of each test case, we are using this if else condition
		
		if(requestSpec==null)
		{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt")); // to log the request in a seperate file(we provided text file)
		
		//RequestLoggingFilter - to log the request either in console or as a file or other. 
		//Hence we've created a reference variable/object with PrintStream class
		//Here, we accessed the getGlobalValue() method
		requestSpec = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log)) 
				.addFilter(ResponseLoggingFilter.logResponseTo(log)) // we are logging both request and response in the same file 'logging.txt'
		.setContentType(ContentType.JSON).build();
		
		return requestSpec;
		}
		return requestSpec; //else condition

	}
	public ResponseSpecification responseSpecification()
	{
		responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		return responseSpec;
	}

	// We made it static so that this method can be directly accesssed. We can use inheritance concept for this but we are in same class.
	public static String getGlobalValue(String key) throws IOException 

	
	{
		//'Properties' class from java.util
		Properties prop = new Properties(); //This 'prop' object can scan any file, which is having '.properties' extension.
		//But, it don't know where the file is. So, we need to integrate it with 'fis' as  it knows where the file is - as we provided the location
		
		FileInputStream fis = new FileInputStream("C:\\Java\\RestAssuredCucumber\\src\\test\\java\\resources\\global.properties"); 
		//we used input stream instead of output stream  Because we read the data from a file
		//If we want to write a data in a file, we use FileOutputStream
		
		prop.load(fis);//integrating the prop with fis and loading it.
		
		return prop.getProperty(key); //getting the data(a string value) in the properties file
		
		//we provided the key value as 'baseUrl' in 'global.properties' file
		//we used 'String key' as a parameter in the method to avoid hardcoding - means to avaid providing the name directly
		//Because, the name/data can be changed when reqired. So, to accept even whatever the name present, we used parameterizing
		
	}
	
	public String getJsonPath(Response response, String key)
	{
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}

	}

