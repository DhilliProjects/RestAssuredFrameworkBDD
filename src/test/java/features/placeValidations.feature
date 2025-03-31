 Feature: Validating Place APIs

 @AddPlace
 Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI
 Given Add Place Payload with "<Name>" "<Language>" "<Address>"
 When User calls "AddPlaceAPI" with "POST" HTTP request
 Then API call is success with status code 200
 And "status" in response body is "OK"
 And "scope" in response body is "APP"
 And Verify place_id created maps to "<Name>" using "GetPlaceAPI"

 Examples:
 
	| Name     | Language | Address   |
	| C Home   | Telugu   | Sklm      |
 #| Our Home | English  | Hyderabad |
 
 
 #We can use the same lines that we used in other test cases.
 #So we don't need to write any code for it - just need specific modifications if required
 
 @DeletePlace
 Scenario: Verify if Delete Place functionality is working
 Given DeletePlace Payload
 When User calls "DeletePlaceAPI" with "POST" HTTP request
 Then API call is success with status code 200
 And "status" in response body is "OK" 
 