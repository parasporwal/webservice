package com.qainfotech;
import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class Basic {
      private String BASEURI="http://10.0.1.86/snl";
      private String BASEPATH="/rest/v1";
      private String response;
      private Board board;
     
      
      @BeforeClass
      public void setURL(){
    	  System.out.println("dkgetu4iofjsdfkl");
    	  RestAssured.baseURI=BASEURI;
    	  RestAssured.basePath=BASEPATH;
    	  response= given().
    			    when().
    			       get("/board/new.json").
    			    then(). 
    			        assertThat().statusCode(200). 
    			    extract(). 
    			     body().asString();
    	 
    	  int id=JsonPath.read(response, "$.response.board.id");
    	  board=new Board();
    	  board.setId(id);
    		
      }
	
      @Test
	public void testForStatusCode(){
    	 
		//System.out.println(response);
    	  
    	
		
	
	}
      @Test
     public void testIsPlayerAdd(){
    	 System.out.println("heheehehehe");
    	 response= given().
    			 contentType(ContentType.JSON).
    			 body("{\"board\":"+board.getId()+",\"player\":{\"name\":\"paras\"}}").
   			    when().
   			       post("/player.json").
   			    then(). 
   			        assertThat().statusCode(200). 
   			    extract(). 
   			     body().asString();
    	
    	 System.out.println(response);
    	 
    	
      }
}
