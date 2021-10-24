package com.instanthelp;
import java.util.Scanner;

public class UserAccount {
    int number =0;
    private ServiceDetail cleaning;
    private ServiceDetail plumbing;
    private ServiceDetail gardening;
    private ServiceDetail electrician;
    private ServiceDetail ac;
    private ServiceDetail painting;

	public Person createPerson(String n, String e, String pno, String addr, String type) {
		Person p = null;
		
        cleaning = new Cleaning();
        plumbing = new Plumbing();
        gardening = new Gardening();
        electrician = new Electrician();
        ac = new ACRepairingServices();
        painting = new Painting();
		if (type.equals("user")) {
			p = new User(n, e, pno,  addr);
			
		} else if (type.equals("sp")) {
			p = new ServiceProvider(n, e, pno,  addr);
		}
		return p;

}
	

}