import java.util.*;

public class EmpWageBuilder{
	public static final int IS_FULL_TIME = 2;		//made final for constants
	public static final int IS_PART_TIME = 1;

	private int number_of_companies=0;

	// using ArrayList to store the data
	private ArrayList<CompanyEmpWage> companyWageArrayList= new ArrayList<CompanyEmpWage>();

	// using Dictionary to store total employee wage store
	private Dictionary<String,Integer> totalWageStore = new Hashtable<String,Integer>();

	//adding each company wage data
	private void addCompanyWage(String company, int empRatePerHour, int empWorkingDay, int maxHourInMonth) {
		CompanyEmpWage companyEmpWageData = new CompanyEmpWage(company,empRatePerHour,empWorkingDay,maxHourInMonth);
		companyWageArrayList.add(companyEmpWageData);
		number_of_companies++;
	}

	//computing every company employee wage
	private void computeEmployeeWage(){
		for(int c=0; c<number_of_companies; c++) {
			int totalEmployeeWage = this.calculate_empWage(companyWageArrayList.get(c));
			System.out.println("Total Employee Wage for company "+companyWageArrayList.get(c).company+" is "+totalEmployeeWage);
			totalWageStore.put(companyWageArrayList.get(c).company,totalEmployeeWage);
		}
	}

	public void getTotalEmpWage(){
		int input =2;
		while(input !=0) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the company name");
			String companyName=sc.next();
			System.out.println("The total employee wage of " +companyName+ " is : "+totalWageStore.get(companyName));
		}
	}

	public int calculate_empWage(CompanyEmpWage companyEmpWage) {

		int empHours = 0;
		int empWorkingDay =0;
		int totalEmpHours=0;

		while(totalEmpHours <= companyEmpWage.maxHourInMonth && empWorkingDay < companyEmpWage.workingDays) {
			empWorkingDay++;
			int empCheck = (int) Math.floor(Math.random() * 10) % 3;
			switch(empCheck) {
				case IS_FULL_TIME :
					empHours =8;
					break;
				case IS_PART_TIME :
					empHours = 4;
					break;
				default:
					empHours = 0;
			}

			totalEmpHours = totalEmpHours + empHours;
			int dailyWage= companyEmpWage.empRatePerHour*empHours;
			System.out.println("Day : "+ empWorkingDay+ " Employee Hour : "+empHours+" and daily wage : "+dailyWage);
		}
		return totalEmpHours *companyEmpWage.empRatePerHour;
	}

	public static void main(String [] args) {
		EmpWageBuilder empWageBuilder = new EmpWageBuilder();
		empWageBuilder.addCompanyWage("DMart",10,2,5);
		empWageBuilder.addCompanyWage("VMart",20,4,25);
		empWageBuilder.computeEmployeeWage();
	}

	public class CompanyEmpWage {

		public final String company;
		public final int empRatePerHour;
		public final int workingDays;
		public final int maxHourInMonth;

		public CompanyEmpWage(String company, int empRatePerHour, int workingDays, int maxHourInMonth) {
			this. company=company;
                	this.empRatePerHour=empRatePerHour;
                	this.workingDays=workingDays;
                	this. maxHourInMonth=maxHourInMonth;
		}

	}
}
