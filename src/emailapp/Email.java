package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private int defaultPasswordLenght=10;
	private String department;
	private int mailBoxCapacity=500;
	private String alternateEmail;
	private String email;
	private String companySuffix="aEYcompany.com";
	
	//Constructor to receive firstName and lastName
	public Email(String firstName, String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		
		//call a method asking for department
		this.department= setDepartment();
		
		//call a method to generate a random password
		this.password= randomPassword(defaultPasswordLenght);
		
		//Combine all element to generate email for New hired Associate based on business requirement.
		email= firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
	}
	
	
	//Ask for department
	private String setDepartment() {
		System.out.println("New Employee"+firstName+".Department Code\n1 for Sales\n2 for Development\n3 for accounting\n0 for none\nEnter the department code:");
		Scanner sc = new Scanner(System.in);
		int departmentChoice= sc.nextInt();
		if(departmentChoice == 1)
			return "sales";
		else if(departmentChoice==2)
			return "development";
		else if(departmentChoice==3)
			return "accounting";
		else
			return "";	
	}
	
	//Generate random password
	private String randomPassword(int lenght) {
		
		String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@$&";
		char[] password= new char[lenght];
		for (int i=0;i<lenght;i++) {
			int rand=(int)(Math.random()*lenght);
			password[i]=passwordSet.charAt(rand);
		}
		return new String(password);
	}
	//Set mailbox capacity
	public void setMailBoxCapacity(int capacity) {
		this.mailBoxCapacity= capacity;
	}
	
	//Set the alternate email
	public void setAlternateEmail(String altemail) {
		this.alternateEmail= altemail;
	}
	//Change the password
	public void changePassword(String password) {
		this.password= password;
	}


	public String getPassword() {
		return password;
	}
	public int getMailBoxCapacity() {
		return mailBoxCapacity;
	}
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	
//methods to display the name, email and mailbox capacity
	public void showInfo() {
		String show= "Display Name: " +firstName+" "+lastName+
				"\nCompany Email: "+email+
				"\nMailbox Capacity: "+mailBoxCapacity;
		System.out.println(show);
		System.out.println("Your Password is: "+this.password);
	}
	
}
