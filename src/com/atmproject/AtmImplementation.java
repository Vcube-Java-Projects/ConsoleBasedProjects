package com.atmproject;

import java.util.Scanner;

public class AtmImplementation implements AtmInterface {
	Scanner sc = new Scanner(System.in);
	User u1;

	AtmImplementation(User u) {
		u1 = u;

	}

	@Override
	public void checkBalnce() {
		System.out.println("balance:" + u1.getBalance());

	}

	@Override
	public void deposit() {
		System.out.println("enter amount to deposit");
		double amount = sc.nextDouble();
		double balance = u1.getBalance();
		balance = balance + amount;
		u1.setBalance(balance);
		System.out.println("deposit completed succesfully");
	}

	@Override
	public void withdraw() {
		System.out.println("enter amount to withdraw:");
		double amount = sc.nextDouble();
		if (amount > u1.getBalance()) {
			System.out.println("insufficient funds");
		} else {
			double balance = u1.getBalance();
			balance = balance - amount;
			u1.setBalance(balance);
			System.out.println("withdraw completed succesfully");
		}

	}

	@Override
	public void pinChange() {
		System.out.println("enter yout old pin");
		int oldpin = sc.nextInt();
		if (oldpin == u1.getPin()) {
			System.out.println("enter new pin");
			int newpin = sc.nextInt();
			System.out.println("pin changed successfully");
			u1.setPin(newpin);
		} else {
			System.out.println("inavalid pin");
		}

	}

}
