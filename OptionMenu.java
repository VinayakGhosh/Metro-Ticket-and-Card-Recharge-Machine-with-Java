import java.util.Scanner;
public class OptionMenu extends Machine {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		Machine m1 = new Machine();
		System.out.println("Welcome to Metro Ticket Machine.");
		int x = 0;
		do {
			System.out.println("Please select one of these");
			System.out.println("1) Recharge Metro Card");
			System.out.println("2) Get Token Ticket");
			System.out.println("3) Exit");
			
			int select = sc.nextInt();
			switch(select) {
			case 1:
				m1.cardRecharge();
				break;
			case 2:
				m1.showStation();
				m1.calcFare();
				
				break;
			case 3:
				x=1;
				break;
			default:
				System.out.println("Invalid Character.");
			}
		}while(x==0);
		System.out.println("Thank You for using the Metro Ticket Machine.");
		System.out.println("Have a nice day!");	
	}

}
