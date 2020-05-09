public class EmpWageBuilder{
	public static final int IS_FULL_TIME = 2;		//made final for constants
	public static final int IS_PART_TIME = 1;

	private int number_of_companies=0;
	public CompanyEmpWage [] array;

	public EmpWageBuilder() {
		array = new CompanyEmpWage[5];
	}

	//adding each company wage data
	private void addCompanyWage(String company, int empRatePerHour, int empWorkingDay, int maxHourInMonth) {
		array[number_of_companies] = new CompanyEmpWage(company,empRatePerHour,empWorkingDay,maxHourInMonth);
		number_of_companies++;
	}

	//computing every company employee wage
	private void computeEmployeeWage(){
		for(int c=0; c<number_of_companies; c++) {
			int totalEmployeeWage = this.calculate_empWage(array[c]);
			System.out.println("Total Employee Wage for company "+array[c].company+" is "+totalEmployeeWage);
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
			System.out.println("Day : "+ empWorkingDay+ " Employee Hour : "+empHours);
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
