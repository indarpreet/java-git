package com.java.spring;


import com.fasterxml.jackson.core.io.JsonEOFException;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

// Integration test
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloWorldIntegrationTest {

    @Autowired
    private  TestRestTemplate restTemplate;   
    
    @Test
    public void contextLoads() throws JSONException{
      String response = this.restTemplate.getForObject("/dummy-item-service-repo", String.class);
      JSONAssert.assertEquals("[{id:10001},{id:10002},{id:10003}]", response, false);

    }
}
