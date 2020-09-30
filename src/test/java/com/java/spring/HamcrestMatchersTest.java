package com.java.spring;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    public void hamrestAssert(){
        List<Integer> numbers = Arrays.asList(12,15,45);
        assertThat(numbers , hasSize(3));
        assertThat(numbers, hasItems(12,15));
        assertThat(numbers, everyItem(greaterThan(10)));
        assertThat(numbers, everyItem(lessThan(100)));
    }

    
    
   
}
