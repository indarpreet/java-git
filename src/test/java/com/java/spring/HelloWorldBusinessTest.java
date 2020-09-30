package com.java.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.java.spring.entity.Item;
import com.java.spring.entity.Student;
import com.java.spring.repository.ItemRepository;
import com.java.spring.repository.UserRepository;
import com.java.spring.service.UserService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// @SpringBootTest
@ExtendWith(MockitoExtension.class)
class DemoApplicationTests {
	@InjectMocks
	static UserService userService;
	@Mock
	static UserRepository userRepository; //= mock(UserRepository.class);

	@Mock
	static ItemRepository itemRepository;
	
	static List<Student> students = new ArrayList<>();

	@BeforeAll
	public static void before(){
		students.add(new Student("Sokhi"));
		//userService.setUserRepository(userRepository);
	}

	@Test
	void calculateSum() {
		//UserService userService = new UserService();
		int calculateSum = userService.calculateSum(new int[] {1,2,3});
		assertEquals(6, calculateSum);
	}

	@Test
	void calculateSumEmpty() {
		//UserService userService = new UserService();
		int calculateSum = userService.calculateSum(new int[] {});
		int expectedResult = 0;
		assertEquals(expectedResult, calculateSum);
	}

	@Test
	public void getUserDetails(){
		when(userRepository.findAll()).thenReturn(students);
		List<Student> stds = userService.getUserDetails();
		assertEquals(1, stds.size());
	}

	// Argument Matchers
	// Verification Basics
	// Verify if the method is called !
	// Verify if correct argument is captured
	@Test
	public void argumentMatchersAndVerify(){
	  List<String> list =  mock(List.class);
	  when(list.get(0)).thenReturn("Hi");
	  list.get(0);
	  verify(list , atLeastOnce() ).get(anyInt());
	}


	@Test
	public void argumentCaptor(){
	  List<String> list =  mock(List.class);
	 
	  list.add("test");

	  ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
	  verify(list).add(captor.capture());
	  // captor.getAllValues()  - for multiple calls and change the verify method to change number of times

	  assertEquals("test", captor.getValue());
	  
	}


     
    @Test
    public void testGetItemFromServiceDaoServiceLayer() throws Exception {
        
        when(itemRepository.findAll()).thenReturn(
            Arrays.asList(new Item(123, "Indarpreet", 120, 2))
        );
        List<Item> items = userService.getItemFromRepo();
        assertEquals(240, items.get(0).getValue());

    }
	
}
