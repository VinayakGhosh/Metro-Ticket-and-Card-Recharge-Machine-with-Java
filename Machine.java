import java.util.Scanner;
public class Machine  {
	
	Scanner sc = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);
	
	private int no_Station = 11, registeredPins=10;
	private double fare, tempMoney;
	
	//data regarding station names, card info
	private String stn_Name[] = {"Mayur Vihar 1", "Akshardham", "Noida Sec 15", "Rajiv Chowk", "Mandi House",
				     "Dhaula Kuan", "Dwarka Sec 21", "Chandni Chowk", "Delhi Gate","Lajpat Nagar", "Jama Masjid" };
	private int cardPin[] = {4440, 4441,4442,4443,4444,4445,4446,4447,4448,4449};
	private double cardBalance[] = {12.25, 20, 220, 100.2, 156, 16.63, 501, 10, 450, 52.31};
	private String cardHolderName[] = {"Mr. A", "Ms. B", "Ms. C", "Mr. D", "Ms. E", "Mr. F", "Ms. G", "Mr. H", "Ms. I", "Mr. J"};
	
	//method for adding money to card
	public void cardRecharge() {
		int pin;
		System.out.print("\nPlease Enter your Card in the Machine and Enter the Card PIN: ");
		pin = sc.nextInt();
		int flag = 0;
			for(int i=0; i<registeredPins; i++) {				
				if(pin == cardPin[i]) {
					flag = 1;
					System.out.println("Card Holder Name: "+cardHolderName[i]);
					System.out.println("Amount Present = Rs "+cardBalance[i]);
					System.out.print("Enter amount you want to add: ");		
					
					tempMoney = sc.nextDouble();
					cardBalance[i]+=tempMoney;					
					System.out.println("\nAmount added to your Card");
					System.out.println("New Balance = Rs "+cardBalance[i]+"\n");
					
					//Print Reciept
					System.out.println("Do you want to print reciept?(y/n)");
					char c = sc2.next().charAt(0);
					if(c == 'Y' || c == 'y') {
						System.out.println("Reciept is being printed. Please collect Reciept.\n");
					}
				} 
			}		
			if(flag==0) {
				System.out.println("INVALID PIN! Please enter correct PIN.");				
				cardRecharge();
			}
		}
	
	//method to show stations
	public void showStation() {
		System.out.println("\nStation\t\t\t\tCode");
		System.out.println("------------------------------------");
		for(int i=0; i<no_Station; i++) {
			System.out.println( stn_Name[i] + "\t\t:\t "+ (500+ i));
		}
	}
	
	//method for calculating fare
	public void calcFare() {
		int stnCode1, stnCode2;
		
		System.out.print("\nEnter code of your Boarding Station: ");
		stnCode1 = sc.nextInt();
		System.out.print("Enter code of your Destination Station: ");
		stnCode2 = sc.nextInt();
		
		if(stnCode1 > no_Station + 500 || stnCode2 < 500) {
			System.out.println("Invalid Station Code! Please Enter correct Station Code.");
			calcFare();
		} else if(stnCode2 > no_Station + 500 || stnCode1 < 500) {
			System.out.println("Invalid station code! Enter correct code.");
			calcFare();
		} else {
			if(stnCode2>stnCode1) 
				fare = 10 + ((stnCode2-stnCode1)*1.75);
			else 
				fare = 10 + ((stnCode1-stnCode2)*1.75);
			System.out.println("Total cost of Trip = Rs "+fare);
			System.out.println("Token is generated. Please collect the token.");
			
			//Print Reciept
			System.out.println("\nDo you want to print reciept?(y/n)");
			char c = sc2.next().charAt(0);
			if(c == 'Y' || c == 'y') {
				System.out.println("Reciept is being printed. Please collect Reciept.");
			}
			System.out.println();
		}
	}
}
	
	
	