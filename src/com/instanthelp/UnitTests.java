package com.instanthelp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnitTests {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		 UserAccount u = new UserAccount();
	     UserStore us = new UserStore(u);
	     Person person = us.create("James","james@email.com" ,"+676352", "London,UK", "user");
	     
    	 User user = new User("James","james@email.com" ,"+676352", "London,UK");
    	 ServiceProvider sp = new ServiceProvider("James","james@email.com" ,"+676352", "London,UK");

    	 System.out.println(person);
         
	     Person serviceProvider = us.create("James","james@email.com" ,"+676352", "London,UK", "sp");
	     System.out.println(serviceProvider);
	     
	     AddServices services = new AddServices();
	     Iterator serviceIterator = services.createIterator();
	     
	     MainClass m = new MainClass();
	     m.print(serviceIterator);
	     
	     ServiceDetail cleaning = new Cleaning();
		 cleaning.details();

		 ServiceDetail plumbing = new Plumbing();
		 plumbing.details();
		 
		 user.placeOrder();
 		 sp.placeOrder();

 		 user.deliverOrder();
 		 sp.deliverOrder();
 		 sp.endOrder();
 		 
	}

}
