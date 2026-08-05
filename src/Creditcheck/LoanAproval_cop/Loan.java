package LoanAproval_cop;

import java.util.Scanner;

public class Loan {
	static Scanner sc = new Scanner(System.in);
	
	void getLoanDocInfo() {
		System.out.println("All docs submitted Successfully !!");
	}
	
	double getROI() {
		return 10.5;
	}

	void Customerdetails() {
		System.out.println("Enter flot number : ");
		String flot = sc.next();
		System.out.println("Enter Street : ");
		String Street = sc.next();
		System.out.println("Enter city : ");
		String city = sc.next();
		System.out.println("Enter pincode : ");
		int pin = sc.nextInt();

		System.out.println("Flot no : " + flot + " Street : " + Street + " city : " + city + " pincode " + pin

		);
	}

	String getCustomername() {
		System.out.println("Enter Customer Name : ");
		String s = sc.nextLine();
		return s;
	}

	int getCustomerCibil() {
		System.out.println("Enter your cibil Score : ");
		int c = sc.nextInt();
		return c;
	}

	int getCustomerAge() {
		System.out.println("Enter your Age : ");
		int a = sc.nextInt();
		return a;
	}

	double getCustomerSalary() {
		System.out.println("Enter your Salary : ");
		double d = sc.nextDouble();
		return d;
	}

	boolean validCustomerPhonenumber() {
		System.out.println("Enter your Phonenumber : ");
		String d = sc.next();
		return d.matches("[6-9]\\d{9}");
	}

	boolean validCustomerPan() {
		System.out.println("Enter your PAN number : ");
		String d = sc.next();
		return d.matches("[A-Z]{5}[1-9]{4}[A-Z]{1}");
	}

	boolean validCustomerAdhar() {
		System.out.println("Enter your ADHAR : ");
		String d = sc.next();
		return d.matches("\\d{12}");
	}

}
