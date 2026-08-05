package LoanAproval_cop;

import java.util.Scanner;

public class PersonalLoan extends Loan {
	static Scanner sc = new Scanner(System.in);

	static boolean isEligibleBasedonExpenses() {
		System.out.println("Enter your Monthly Expenses : ");
		double d1=sc.nextDouble();
		System.out.println("Enter your Salary : ");
		double d2=sc.nextDouble();
		
		if(d2-d1>2000) {
			return true;
		}
		else {
			return false;
		}
		
	}

	public static void main(String[] args) {
		System.out.println("Welcome to smart Loan Aproval");

		Loan l = new Loan();
		String cname = l.getCustomername();
		int cibil = l.getCustomerCibil();
		int age = l.getCustomerAge();
		double salary = l.getCustomerSalary();
		if (cibil > 770 && age > 26 && salary > 1000000 && l.validCustomerAdhar() && l.validCustomerPan()
				&& l.validCustomerPhonenumber() &&isEligibleBasedonExpenses()) {
			System.out.println("Congrtulations !! Your Personal Loan got Aproved");
			System.out.println("Your personal Loan ROI : " + l.getROI());
			System.out.println("As entered Confirming Your Detials are : ");
			l.Customerdetails();
			l.getLoanDocInfo();

		} else {
			System.out.println("Sorry you are not Eligible for home loan!!");

		}
	}
}
