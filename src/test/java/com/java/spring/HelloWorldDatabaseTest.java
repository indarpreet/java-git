package com.java.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.java.spring.entity.Item;
import com.java.spring.repository.ItemRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class HelloWorldDatabaseTest {

    @Autowired
    ItemRepository itemRepository;
    
    @Test
    public void findAll(){
       List<Item>  items = itemRepository.findAll();
       assertEquals(3 , items.size());
    }
}
