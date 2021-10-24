package com.instanthelp;
//In this project, I implement 4 design patterns
// 1. Factory design pattern : it is used to create user and service provider account
// 2. Composite design pattern : it is used to add the services
// 3. Facade design pattern: it is used to get the detail of service provider with their respective service
// 4. command design pattern: it is used to place and deliver order.
import java.util.Scanner;

public class MainClass {

	public static void main(String args[])
	  {
		String name;
		String email;
		String phoneno;
		String address;
		String type; 
		int n;
		String choice;
	 
	    Scanner in = new Scanner(System.in);
	 
	     //Get input String
	     System.out.println("Enter your name: ");
	     name = in.nextLine();
	     System.out.println("Enter your email: ");
	     email = in.nextLine();
	     System.out.println("Enter your phoneno: ");
	     phoneno = in.nextLine();
	     System.out.println("Enter your address: ");
	     address = in.nextLine();
	     System.out.println("Enter user type as user or sp: ");
	     type = in.nextLine();
	     UserAccount u = new UserAccount();
	     UserStore us = new UserStore(u);
	     if (type.equals("user"))
	      {	
	    	 Person person = us.create(name, email, phoneno, address, type);
	    	 User user = new User(name, email, phoneno, address);
	    	 ServiceProvider sp = new ServiceProvider(name, email, phoneno, address);
	    	 user.createOrder(new OrderService(sp));

	    	    AddServices services = new AddServices();
				Iterator serviceIterator = services.createIterator();

				System.out.println("\nThe services which we offer is as follows:");
				print(serviceIterator);
				System.out.println("\nKindly select the services");
				  int number =0;
				  ServiceDetail cleaning = new Cleaning();
				  ServiceDetail plumbing = new Plumbing();
				  ServiceDetail gardening= new Gardening();
				  ServiceDetail electrician= new Electrician();
				  ServiceDetail ac = new ACRepairingServices();
				  ServiceDetail painting = new Painting();

				number=in.nextInt();
				if(number ==1)
				{
					cleaning.details();
				}
				else if(number == 2)
				{
					plumbing.details();
				}
				else if(number == 3)
				{
					gardening.details();
				}else if(number == 4)
				{
					electrician.details();
				}else if(number == 5)
				{
					ac.details();
				}else if(number == 6)
				{
					painting.details();
				}
				else
				{
					System.out.println("Invalid Choice!!!");
				}
	    	System.out.println("Do you want to place an order? y/n");
	    	choice =in.nextLine();
	    	if(choice.equals("y"))
	    	{
	    		user.placeOrder();
	    		sp.placeOrder();
		    	System.out.println(" ");

	    		user.deliverOrder();
	    		sp.deliverOrder();
		    	System.out.println(" ");

	    		sp.endOrder();
	    	}
	    	else if(choice.equals("n"))
	    	{
		    	System.out.println("You didn't place any order !!!");
		    	System.exit(0);
	    	}
	    	else 
	    	{
		    	System.out.println("Invalid choice !!!");
	    	}
		  } else if (type.equals("sp"))
		  {
			 Person person = us.create(name, email, phoneno, address, type);
			 System.out.println(person);
		  }
	     
	  }
	public static void print(Iterator iterator) {
		int i= 1;
		
		while (iterator.hasNext()) {
			String menuItem = (String)iterator.next();
			System.out.println(i +" "+menuItem);
			i++;
			

		}
	}
}