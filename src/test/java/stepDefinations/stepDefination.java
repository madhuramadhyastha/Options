package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.Request;

import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class stepDefination {	
	
	
	RequestSpecification req;
	Response res;
	
	@Given("user sets up a request")
	public void user_sets_up_a_request() throws IOException {       
			req= given().baseUri("http://api.openweathermap.org/data/2.5/")
			.queryParam("appid", "1b9a4cf6f5eecebb884e5b6e7144cb98").queryParam("q","London");
	}
	@When("user calls forecast api with city")
	public void user_calls_forecast_api_with_city() {
			
			res=req.when().post("weather");
			assertEquals(res.getStatusCode(),200);

			String resp=res.asString();
			JsonPath js = new JsonPath(resp);
			String temperature = js.get("main").toString();
			String wind = js.get("wind").toString();
			System.out.println(temperature);
			System.out.println(wind);
			
			//check for 5 day temperature
			//detailed one containing temp and wind
			
	}
	@When("user calls forecast api with weather for day")
	public void user_calls_forecast_api_with_weather_for_day() {
	    
		req= given().baseUri("http://api.openweathermap.org/data/2.5/")
		.queryParam("appid", "1b9a4cf6f5eecebb884e5b6e7144cb98").queryParam("q","London");
		res=req.when().post("find");
		assertEquals(res.getStatusCode(),200);
		//check response contains only 3 hrs forecast

	}	
			
			
			
			
	}	



