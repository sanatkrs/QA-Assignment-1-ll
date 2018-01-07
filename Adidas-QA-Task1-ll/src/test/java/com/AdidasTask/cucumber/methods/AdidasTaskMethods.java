package com.AdidasTask.cucumber.methods;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.AdidasTask.model.AdidasTaskClass;
import com.AdidasTask.testbase.TestBase;
import com.AdidasTask.utils.TestProperties;
import com.cucumber.listener.Reporter;

import io.restassured.RestAssured;
import io.restassured.response.Response;





public class AdidasTaskMethods extends TestBase {
	

	
	public void Verify_status_Code() throws IOException{
		RestAssured
		.given()
		.when()
		.get(TestProperties.base_api)
		.then()
		.statusCode(200);
		Reporter.addStepLog("Status Code is 200");
		
	}
	
	
	
	@Test
	public void testResponsTime(){
		Response response = RestAssured
		.given()
		.when()
		.get(TestProperties.base_api);		
		int time = (int) response.then().extract().time();			
		if(time < 1000){
			AssertJUnit.assertTrue(true);
			Reporter.addStepLog("Response time is " + time + " miliseconds which is less then 1 second.");
			}
		else{
			Reporter.addStepLog("Response time is " + time + " miliseconds which is greater then 1 second.");
			AssertJUnit.assertTrue(false);
		}

	}
	public ArrayList<String> GetUrls() {
		
		ArrayList<String> urls = new ArrayList<String>();
		
		String components = 
				given()
				.when()
				.get(TestProperties.base_api).asString();
	
	JSONObject obj = new JSONObject(components);
	JSONArray value = obj.getJSONArray("component_presentations");
	
	  for (int i = 0; i < value.length(); i++) {
          JSONObject component = value.getJSONObject(i);
          
          if(value.getJSONObject(i).toString().contains("url")){
        	  
        	  JSONArray items = component.getJSONObject("component").getJSONObject("content_fields").getJSONArray("items");
        	  
              for (int j = 0; j <  items.length(); j++) {
                  if(items.getJSONObject(j).has("background_media")){
            	  
                	  String sUrl = items.getJSONObject(j).getJSONObject("background_media").getJSONObject("desktop_image").getString("url");
                	  urls.add(sUrl);
                
                	  sUrl = items.getJSONObject(j).getJSONObject("background_media").getJSONObject("tablet_image").getString("url");
                	  urls.add(sUrl);
                  
                	  sUrl = items.getJSONObject(j).getJSONObject("background_media").getJSONObject("mobile_image").getString("url");
                	  urls.add(sUrl);
                  }
                  if(items.getJSONObject(j).has("media_items")){
                	  
                	  String sUrl = items.getJSONObject(j).getJSONObject("media_items").getJSONObject("desktop_image").getString("url");
                      urls.add(sUrl);
                      
                      sUrl = items.getJSONObject(j).getJSONObject("media_items").getJSONObject("tablet_image").getString("url");
                      urls.add(sUrl);
                      
                      sUrl = items.getJSONObject(j).getJSONObject("media_items").getJSONObject("mobile_image").getString("url");
                      urls.add(sUrl);
                      
                      }
              		}
          		}  
	  		}
	  				Reporter.addStepLog("Total number of Urls found: " + urls.size());
	  				AssertJUnit.assertNotNull(urls);
	  				Reporter.addStepLog("Script is successfully able to extract the Urls");
	  
	  
	  
	  
	  
	  return urls;
	}
                
  
	
	
	
	
	public int HttpUrlConnect(String Urls) throws IOException {

			URL url = new URL(Urls);
			HttpURLConnection httpURLConnect = (HttpURLConnection)url.openConnection();
			httpURLConnect.setRequestMethod("GET");
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();
			int response  = httpURLConnect.getResponseCode();
		return response;	
		//(httpURLConnect.getResponseCode()== HttpURLConnection.HTTP_NOT_FOUND)
	}
	
	
	public void Check_Response_Code() throws IOException{
		
		List<String> ImageUrls = GetUrls();
		for(int i=0; i < ImageUrls.size(); i++ ){
			
			String Urls = ImageUrls.get(i);
			int response =	HttpUrlConnect(Urls);
			Reporter.addStepLog("Urls no. " + (i+1) + "----------> " + response);
			AssertJUnit.assertEquals(response, 200);
			
			}
		Reporter.addStepLog("All Urls Status code is 200");
	}

	
	
	

	public JSONArray GetAllComponents(){
		
		String components = 
				given()
				.when()
				.get(TestProperties.base_api).asString();
		JSONObject obj = new JSONObject(components);
		JSONArray value = obj.getJSONArray("component_presentations");
		AssertJUnit.assertNotNull(value);
		Reporter.addStepLog("successfully got all the components: Total no of componetent found " + value.length() );
		return value;
		
	}
		

	public void Check_Analytics_Data(){
		int count = 0;
				for(int i =0;i < GetAllComponents().length(); i++ ){
			JSONObject Componentpresent = GetAllComponents().getJSONObject(i);
			JSONObject Component = Componentpresent.getJSONObject("component");
				if(Component.toString().contains("analytics_name")){
					Reporter.addStepLog(i+1 + "th Component has analytics name");
					count++;
							}
				else{
					Reporter.addStepLog(i+1 + "th Component has no analytics name");
				}
						}
				Reporter.addStepLog("Total presence of analytics_name ---> " + count );	
				Reporter.addStepLog("Total components found ---> " + GetAllComponents().length() );
				Assert.assertEquals(count, GetAllComponents().length(), "analytics_name occurence in each component should be 1");
					}	
				}
			
			
			
			
			
			
			