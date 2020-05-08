public class EmpWageBuilder{
	public static final int IS_FULL_TIME = 2;		//made final for constants
	public static final int IS_PART_TIME = 1;

	private final String company;
	private final int workingDays;
	private final int empRatePerHour;
	private final int maxHourInMonth;

	public EmpWageBuilder(String company, int empRatePerHour,int workingDays, int maxHourInMonth) {
		this.company=company;
		this.workingDays=workingDays;
		this.empRatePerHour=empRatePerHour;
		this.maxHourInMonth=maxHourInMonth;
	}

	public int calculate_empWage() {

		int empHours = 0;
		int empWorkingDay =0;
		int totalEmpHours=0;

		while(totalEmpHours <= maxHourInMonth && empWorkingDay < workingDays) {
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
		return totalEmpHours * empRatePerHour;
	}

	public static void main(String [] args) {
		EmpWageBuilder dMart = new EmpWageBuilder("DMart",10,2,5);
		EmpWageBuilder vMart = new EmpWageBuilder("VMart",20,4,25);

		System.out.println("Total Employee Wage for company "+ dMart.company+" is : " +dMart.calculate_empWage());
		System.out.println("Total Employee Wage for company "+ vMart.company+" is : "+vMart.calculate_empWage());
	}

}
