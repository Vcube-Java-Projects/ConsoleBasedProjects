package com.atmproject;

public class User {
int accno;
String accholdername;
int pin;
double balance;

public int getAccno() {
	return accno;
}

public void setAccno(int accno) {
	this.accno = accno;
}

public String getAccholdername() {
	return accholdername;
}

public void setAccholdername(String accholdername) {
	this.accholdername = accholdername;
}

public int getPin() {
	return pin;
}

public void setPin(int pin) {
	this.pin = pin;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

public User(int accno, String accholdername, int pin, double balance) {
	super();
	this.accno = accno;
	this.accholdername = accholdername;
	this.pin = pin;
	this.balance = balance;
}
User(){

}
}
