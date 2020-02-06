package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String department;
	private String companySuffix = "RishabhSoft.com";
	private String alternateEmail;
	private int defaultpasswordLength = 10;
	private int mailBoxCapacity = 500;
	Scanner sc;

	// Constructor
	public Email() {

		// call to a method asking for first name and Last name
		this.firstName = setFirstName();
		this.lastName = setLastName();

		System.out.println("Email created :" + this.firstName + " " + this.lastName);

		// call a method asking for the department = return department
		this.department = setDepartment();
		System.out.println("Department is:" + this.department);

		// call a method that generates a random password
		this.password = generateRandomPassword(defaultpasswordLength);
		System.out.println("Your password is:" + this.password);

		// COmbine elements to generate email syntax;
		if (department == "") {
			email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companySuffix;
			System.out.println("Your email id is:" + email);
		} else {
			email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "."
					+ companySuffix;
			System.out.println("Your email id is:" + email);
		}
	}

//ask for first name
	private String setFirstName() {
		System.out.println("Enter your first name:");
		sc = new Scanner(System.in);
		firstName = sc.next();
		return firstName;
	}

//ask for last name
	public String setLastName() {
		System.out.println("Enter your last name:");
		sc = new Scanner(System.in);
		lastName = sc.next();
		return lastName;
	}

//ask for the department
	private String setDepartment() {
		System.out.println(
				"Codes for departments \n1 Sales \n2 Development \n3 Accounts \n0 None\n Enter a department code: ");
		sc = new Scanner(System.in);
		int selectDept = sc.nextInt();

		if (selectDept == 1)
			return "Sales";
		else if (selectDept == 2)
			return "Development";
		else if (selectDept == 3)
			return "Accounts";
		else
			return "";
	}

//Generate a random password

	private String generateRandomPassword(int length) {
		String passwordSet = "A12345B67890CDEFGHIJKLMNOPQRSTUVWXYZ!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int random = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(random);

		}
		return new String(password);
	}

//set the mailbox capacity(by user)  
	public void setMailBoxCapacity() {
		System.out.println("Enter new Mail box capacity:");
		sc = new Scanner(System.in);
		this.mailBoxCapacity = sc.nextInt();
		System.out.println("Capacity changed to:" + this.mailBoxCapacity);
	}

//check current mail box capacity
	public int getMailBoxCapacity() {
		return mailBoxCapacity;
	}

//set alternate email;
	public void setAlternateEmail() {
		System.out.println("Enter alternate email id:");
		sc = new Scanner(System.in);
		this.alternateEmail = sc.next();
//		System.out.println(this.alternateEmail);
	}

//Change the password
	public void changePassword() {
		System.out.println("Enter new Password:");
		sc = new Scanner(System.in);
		this.password = sc.next();
//		System.out.println("New Password is:" + this.password);
	}

	public String getPassword() {
		return password;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

}
