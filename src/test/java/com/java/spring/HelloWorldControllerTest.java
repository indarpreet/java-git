package com.java.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.java.spring.controller.UserController;
import com.java.spring.entity.Item;
import com.java.spring.repository.ItemRepository;
import com.java.spring.service.UserService;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class HelloWorldControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;


    // unit test to call http request
    // @Test
    public void testHelloWorld() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request)
                // perform request and check status
                .andExpect(status().isOk())
                // check content
                // if response is easy check directly
                .andExpect(content().string("Hello World"))
                // return the object
                .andReturn();

        // if response is complex check using Assert Equals and other libraries
        // assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
    }

    // JSON CHECK checks if elements are missing as well
    @Test
    public void testGetItem() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
        .get("/dummy-item").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request)
        // perform request and check status
        .andExpect(status().isOk())
        // check content 
        // if response is easy check directly
        .andExpect(content().json("{\"id\": 123,\"name\": \"Indarpreet\",\"price\": 120,\"quantity\": 1}"))
        // return the object
        .andReturn();

        // if response is complex check using Assert Equals and other libraries 
        // assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
    }



    @Test
    public void testGetItemFromService() throws Exception {

        when(userService.getItem()).thenReturn(new Item(123, "Indarpreet", 120, 1));

        RequestBuilder request = MockMvcRequestBuilders
        .get("/dummy-item-service").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request)
        // perform request and check status
        .andExpect(status().isOk())
        // check content 
        // if response is easy check directly
        .andExpect(content().json("{id: 123,name: Indarpreet,price: 120,quantity: 1}"))
        // return the object
        .andReturn();

        // if response is complex check using Assert Equals and other libraries 
        // assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
    }


    @Test
    public void testGetItemFromServiceDaoControllerLayer() throws Exception {

        when(userService.getItemFromRepo()).thenReturn(
            Arrays.asList(new Item(123, "Indarpreet", 120, 1))
        );

        RequestBuilder request = MockMvcRequestBuilders
        .get("/dummy-item-service-repo").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request)
        // perform request and check status
        .andExpect(status().isOk())
        // check content 
        // if response is easy check directly
        .andExpect(content().json("[{id: 123,name: Indarpreet,price: 120,quantity: 1}]"))
        // return the object
        .andReturn();

        // if response is complex check using Assert Equals and other libraries 
        // assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
    }




}
