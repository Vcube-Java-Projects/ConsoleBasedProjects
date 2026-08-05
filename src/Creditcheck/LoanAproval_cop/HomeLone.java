package LoanAproval_cop;

public class HomeLone extends Loan {
	@Override
	double getROI() {
		return 10.5;
	}

	static boolean isEligiblePropertyValue() {
	    System.out.println("Enter property value: ");
	    double propertyValue = sc.nextDouble();

	    System.out.println("Enter requested loan amount: ");
	    double loanAmount = sc.nextDouble();
	    if(loanAmount<=(propertyValue *0.8)) {
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to smart Loan Aproval");
		Loan l = new HomeLone();
		String cname=l.getCustomername();
		int cibil=l.getCustomerCibil();
		int age=l.getCustomerAge();
		double salary=l.getCustomerSalary();
		
		if(age>25 && salary>1000000 & cibil>750 && l.validCustomerAdhar()&&l.validCustomerPan()&&l.validCustomerPhonenumber() && isEligiblePropertyValue()) {
			System.out.println("Congrtulations !! Your Home Loan got approved ");
			System.out.println("Your Home Loan ROI is : " + l.getROI());
			System.out.println("As entered Confirming Your Detials are : ");
			l.Customerdetails();
	        l.getLoanDocInfo();
			
			
		}
		else {
			System.out.println("Sorry you are not Eligible for home loan!!");
		}

	}

}
