package com.java.spring.service;

import java.util.List;

import com.java.spring.entity.Item;
import com.java.spring.entity.Student;
import com.java.spring.repository.ItemRepository;
import com.java.spring.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemRepository  itemRepository;

    public List<Student> getUserDetails(){
        return userRepository.findAll();
    }

	public Object postUser(String name) {
		return userRepository.save(new Student(name));
	}
    
    public int calculateSum(int[] data){
        int sum = 0;
        for(int temp : data){
            sum = sum + temp;
        }
        return sum;
    }

	public Item getItem() {
		return new Item(123, "Indarpreet", 120, 2);
    }
    
    public List<Item> getItemFromRepo() {
        List<Item> items = itemRepository.findAll();
        for(Item item : items){
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items;
	}


    // public void setUserRepository(UserRepository userRepository) {
    //     this.userRepository = userRepository;
    // }
}
