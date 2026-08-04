package com.atmproject;

import java.util.Scanner;

public class AtmSystemMain {

	public static void main(String[] args) {
		User[] userArray=new User[4];
		userArray[0]=new User(1345,"mabhunni",1234,9000.00);
		userArray[1]=new User(1346,"mabhunni",1234,9000.00);
		userArray[2]=new User(1347,"mabhunni",1234,9000.00);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter account number");
		int acc=sc.nextInt();
		System.out.println("enter pin number");
		int pin=sc.nextInt();
		User u1=null;
		boolean status=false;
		for(User user:userArray) {
		if(pin==user.getPin()&&acc==user.getAccno()) {
			status=true;
			u1=user;
			break;
			
		}
		}
		System.out.println(u1.getAccholdername()+"welcome to SBI services");
		AtmImplementation atm=new AtmImplementation(u1);
		while(status) {
		System.out.println("1.checkBalance\n2.withdraw\n3.deposit\n4.pin change\n5.exit");
		System.out.println("enter your choice.");
		int n=sc.nextInt();
		switch(n) {
		case 1->atm.checkBalnce();
		case 2->atm.withdraw();
		case 3->atm.deposit();
		case 4->atm.pinChange();
		case 5->{
			status=false;
			System.out.println("thanks for choosing SBI atm services");
		}
		default->System.out.println("inavlid choice you entered");
		
			
		}
		}
	}

}
