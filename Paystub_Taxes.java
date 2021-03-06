	import java.util.Scanner;
public class Paystub_Taxes 
{
	public static void main(String[] args) throws InterruptedException 
	{
		Scanner in = new Scanner(System.in);
		double grossPay;
		double netPay;
		double taxes;
		double hourlyPay;
		double hours;
		double expectedGross;
		double expectedNet;
		double OT;
		double OTpay;
		boolean OTcalc = false;
		String YN;
		
		System.out.println("The first part of this program will determine the \n"
						+ "percentage of your pay being taken out for taxes.\n");
	Thread.sleep(5000);
		System.out.println("Please have your most recent wage statement ready.\n");
		
	Thread.sleep(5000);
		
		System.out.print("Please enter the Gross pay value on your wage statement: ");
			grossPay = in.nextDouble();
		
		System.out.print("Please enter the Net pay value on your wage statement: ");
			netPay = in.nextDouble();
		
		System.out.println("Calculating taxes paid ...\n");
		
	Thread.sleep(3000);
		
			taxes = ((grossPay - netPay) / grossPay);
		
		System.out.println("You paid $" + String.format("%.2f",(grossPay - netPay)) + " in taxes. \n"
				+ "or " + String.format("%.2f",(taxes * 100)) + "% of your Gross Pay.");
	
	Thread.sleep(2000);	
		
		System.out.println("\n\n\nThis next part of the program will help determine how \n"
				+ "much you can expect to be paid next pay period.\n");
	
	Thread.sleep(2000);	
		
		System.out.print("Enter your hourly pay rate: ");
			hourlyPay = in.nextDouble();
		
		System.out.print("Please enter the number of hours you expect to work \n"
				+ "for the next pay period (in decimal form): ");
			hours = in.nextDouble();
			
			if (hours > 40)
			{
				System.out.print("Would you like to calculate OT pay (Time and a Half)? Y/N ");
						YN = in.next();
					
					switch (YN)
					{
					case "y" : case "Y" :
						OTcalc = true;
					break;
					
					case "n" : case "N" :
						OTcalc = false;
					break;
					
					default :
						System.out.println("\nInvalid input. Overtime hours will be calculated \n"
								+ "at normal hourly rates.");
						OTcalc = false;
					}
					
			}
			
			System.out.print("\nCalculating...\n\n");
	
		Thread.sleep(3000);
			
			if (hours > 40 && OTcalc == true)
			{
				OT = hours % 40;
				OTpay = (OT * (hourlyPay + (hourlyPay / 2)));
				
				expectedGross = ((hourlyPay * 40) + OTpay);
				expectedNet = (expectedGross * Math.abs(1 - taxes));
				
				System.out.println("If you work " + hours + " hours; your Gross\n"
						+ "pay will be $" + String.format("%.2f",(expectedGross)) + " at the same tax percentage\n"
								+ "from before (" + String.format("%.2f",(taxes * 100)) + "%)"
										+ " You can expect to net $" + String.format("%.2f", (expectedNet)) + ".");
				
			}
			else
			{
			expectedGross = (hourlyPay * hours);
			expectedNet = (expectedGross * Math.abs(1 - taxes));
						
			System.out.println("If you work " + hours + " hours; your Gross\n"
					+ "pay will be $" + String.format("%.2f",(expectedGross)) + " at the same tax percentage\n"
							+ "from before (" + String.format("%.2f",(taxes * 100)) + "%)"
									+ " You can expect to net $" + String.format("%.2f", (expectedNet)) + ".");
			}
	}

}
