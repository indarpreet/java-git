package com.java.spring;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AssertJTest {
    
    @Test
    public void Assertj(){
        List<Integer> numbers = Arrays.asList(12,15,45);
        assertThat(numbers).hasSize(3).contains(12,15)
        .allMatch(x -> x  > 10)
        .allMatch(x -> x < 100);
        // assertThat(numbers, hasItems(12,15));
        // assertThat(numbers, everyItem(greaterThan(10)));
        // assertThat(numbers, everyItem(lessThan(100)));
    }
}
