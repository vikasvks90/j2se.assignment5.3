/**
* <h1>Employee</h1>
* This program is used manage the salary and leave details of the employee
* @author  Vikas
* @version 1.0
* @since   2017-05-05 
*/
package assignment5.session3;

public class Employee {
	int empId;
	String empName;
	int total_leaves;
	double total_salary;
	int no_of_leaves;
	char type_of_leave;
	
	//Constructor to initialize the employee details
	public Employee(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}
	
	void calculate_balance_leaves(){
		
	};
	
	boolean avail_leave(int no_of_leaves, char type_of_leave){
		return true;
	};
	
	void calculate_salary(){
		
	};
	
	public static void main(String[] args) {
		PermanentEmp permanentEmp1 = new PermanentEmp(123,"Ram");//PermanentEmp object has been created
		TemporaryEmp temporaryEmp1 = new TemporaryEmp(124,"Rohan");//TemporaryEmp object has been created
		permanentEmp1.avail_leave(7, 'P');//call to avail_leave method in PermanentEmp class
		permanentEmp1.calculate_balance_leaves();//call to calculate_balance_leaves method in PermanentEmp class
		permanentEmp1.calculate_salary();//call to calculate_salary method in PermanentEmp class
		System.out.println();
		temporaryEmp1.avail_leave(3, 'C');//call to avail_leave method in PermanentEmp class
		temporaryEmp1.calculate_balance_leaves();//call to avail_leave method in PermanentEmp class
		temporaryEmp1.calculate_salary();//call to avail_leave method in PermanentEmp class
	}

}

/*This class is used to manage all the Permanent employee details*/
class PermanentEmp extends Employee{
	
	//call to super class constructor
	public PermanentEmp(int empId, String empName) {
		super(empId, empName);
		// TODO Auto-generated constructor stub
	}

	int paid_leave = 16;
	int sick_leave = 10;
	int casual_leave = 7;
	double basic = 10000;
	double hra;
	double pf;
	
	@Override 
	//this method will calculate total leaves and will call print_leave_details to print the details
	void calculate_balance_leaves(){
		total_leaves = paid_leave+sick_leave+casual_leave;
		print_leave_details();
	}
	
	@Override 
	//if the employee avails the leaves leaves will be deducted here
	boolean avail_leave(int no_of_leaves, char type_of_leave){
		if(type_of_leave == 'P'){
			paid_leave = 16 - no_of_leaves;
			System.out.println(empName+" has availed "+no_of_leaves+" paid leaves");
		}
		else if(type_of_leave == 'C'){
			casual_leave = 7 - no_of_leaves;
			System.out.println(empName+" has availed "+no_of_leaves+" casual leaves");
		}
		else{
			sick_leave = 10 - no_of_leaves;
			System.out.println(empName+" has availed "+no_of_leaves+" sick leaves");
		}
		return true;
	}
	
	@Override 
	//this method is used to calculate the gross salary of the employee
	void calculate_salary(){
		pf = basic*12/100;
		hra = basic*50/100;
		total_salary = basic+hra-pf;
		System.out.println(empName+"'s gross salary is "+total_salary);
	}
	
	//this method is used to print the details of the employee
	void print_leave_details(){
		System.out.println(empName+" is having "+total_leaves+" leaves left");
	}
}

/*This class is used to manage all the temporary employee details*/
class TemporaryEmp extends Employee{
	//call to super class constructor
	public TemporaryEmp(int empId, String empName) {
		super(empId, empName);
		// TODO Auto-generated constructor stub
	}

	int paid_leave = 12;
	int sick_leave = 8;
	int casual_leave = 5;
	double basic = 7000;
	double hra;
	double pf;
	
	@Override 
	//this method will calculate total leaves
	void calculate_balance_leaves(){
		total_leaves = paid_leave+sick_leave+casual_leave;
		System.out.println(empName+" is having "+total_leaves+" leaves left");
	}
	
	@Override 
	//if the employee avails the leaves leaves will be deducted here
	boolean avail_leave(int no_of_leaves, char type_of_leave){
		if(type_of_leave == 'P'){
			paid_leave = 12 - no_of_leaves;
			System.out.println(empName+" has availed "+no_of_leaves+" paid leaves");
		}
		else if(type_of_leave == 'C'){
			casual_leave = 5 - no_of_leaves;
			System.out.println(empName+" has availed "+no_of_leaves+" casual leaves");
		}
		else{
			sick_leave = 8 - no_of_leaves;
			System.out.println(empName+" has availed "+no_of_leaves+" sick leaves");
		}
		return true;
	}
	
	@Override 
	//employee's gross salary will be calculated here
	void calculate_salary(){
		pf = basic*12/100;
		hra = basic*50/100;
		total_salary = basic+hra-pf;
		System.out.println(empName+"'s gross salary is "+total_salary);
	}
}
