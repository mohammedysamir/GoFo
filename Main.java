package project;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		System.out.println("                                                                  *****************************");
		System.out.println("                                                                  *Welcome to GoFO Applicatoin*                       ");
		System.out.println("                                                                  *****************************");
		Scanner scan=new Scanner(System.in);			// to take inputs
		system sys=new system();			//System
		Admin admin=new Admin("Mariem",sys); //Admin of the System
		sys.AddAdmin(admin);			//Add admin to system
		System.out.println(" ");
		String answer=new String(); //answer to continue or close
		

		do {
		System.out.println("Login ");
		System.out.println("1.Player");
		System.out.println("2.playground Owner");
		int choice=scan.nextInt(); //log in choice
		String Continue=new String("Yes");
		switch(choice) {
		case 1: //show player menu
			//need to loop here as Player

			System.out.println("Insert Data:");
			String FName,Lname,Email,Pass,Phone;
			long Id;
			System.out.print("First name:");
			FName=scan.next();
			System.out.print("Last name:");
			Lname=scan.next();
			System.out.print("Email:");
			Email=scan.next();
			System.out.print("Password:");
			Pass=scan.next();
			System.out.print("Phone:");
			Phone=scan.next();
			System.out.print("ID:");
			Id=scan.nextLong();
			Player player=new Player(FName,Lname,Email,Pass,Phone,Id,"Player");
			sys.AddUser(player);
			/* Player can Book
			 * Add team Member
			 * Show Booked Houres of specific Playground
			 * Print his Data
			 * Check Balance
			 * */
			while(Continue.equalsIgnoreCase("Yes")) { 
			System.out.println("Press 1 to Book Playground");
			System.out.println("Press 2 to Add team member");
			System.out.println("Press 3 to Show Booked Hours of specific playground");
			System.out.println("Press 4 to print your data");
			System.out.println("Press 5 to Check balance");
			int playerchoice=scan.nextInt();
			if(playerchoice==1) {
				System.out.println("Enter Playground Name ");
				String Name=scan.next();
				System.out.println("Enter Time: Day-From:To");
				String Time=scan.next();
				player.Book(Name, Time, sys);
			}
			if(playerchoice==2) {
				//Add member need some modification to be realistic
				//He need to add an existing player not to create new one and add him
			}
			if(playerchoice==3) {
				System.out.println("Enter Playground name:");
				String Name=scan.next();
				player.ViewBookedHours(Name,sys);
			}
			if(playerchoice==4) {
				System.out.println(player.toString());
			}
			if(playerchoice==5) {System.out.println(player.checkbalance());}
			
			System.out.println("If you want to continue as player type Yes");
			Continue=scan.next();
			}
			break;
		case 2:
			//need to loop here as Owner
			//Show Owner Menu
			/*Owner can register playground
			 * View Booked Hours of all his playgrounds
			 * */
			System.out.println("Insert Data:");
			String fname,lname,email,pass,phone;
			long id;
			System.out.print("First name:");
			fname=scan.next();
			System.out.print("Last name:");
			lname=scan.next();
			System.out.print("Email:");
			email=scan.next();
			scan.nextLine();
			System.out.print("Password:");
			pass=scan.next();
			scan.nextLine();

			System.out.print("Phone:");
			phone=scan.next();
			scan.nextLine();

			System.out.print("ID:");
			id=scan.nextLong();
			scan.nextLine();

			PlaygroundOwner Owner=new PlaygroundOwner(fname,lname,email,pass,phone,id,"PlaygroundOwner");
			Owner.setSystem(sys);
			sys.AddUser(Owner);
			while(Continue.equalsIgnoreCase("Yes")) {
			System.out.println("Press 1 to register Playground");
			System.out.println("Press 2 to View Booked Hours of all your Playgrounds");
			System.out.println("Press 3 to Check Balance");
			int OwnerChoice=scan.nextInt();
			if(OwnerChoice==1) {
				System.out.println("Enter Playground's info");
				String pgname,pgphone,pglocation;
				int Rent,ptoCancel;
				float Size;
				System.out.println("Playground's Name:");
				 pgname=scan.next();
				 scan.nextLine();
				System.out.println("Playground's Phone:");
				 pgphone=scan.next();
					scan.nextLine();

				System.out.println("Playground's Location:");
				 pglocation=scan.next();
					scan.nextLine();

				System.out.println("Playground's Rent:");
				Rent=scan.nextInt();
				scan.nextLine();

				System.out.println("Playground's Size");
				Size=scan.nextFloat();
				scan.nextLine();

				System.out.println("Playground's period to cancel:");
				ptoCancel=scan.nextInt();
				scan.nextLine();

				PlayGround pg=new PlayGround(pgphone,pgname,pglocation,Size,Rent,id,ptoCancel);
				Owner.RegisterPlayground(pg);
			}
			if(OwnerChoice==2) {
				Owner.ViewBookedHours();
			}
			if(OwnerChoice==3) {
				System.out.println(Owner.checkbalance());
			}
			System.out.println("If you want to continue as playground(s) Owner type Yes");
			Continue=scan.next();
			}
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}
		System.out.println("**********************************************************************");
		System.out.println("If you want to continue type yes , if not type no to log out and close");
		System.out.println("**********************************************************************");
		answer=scan.next();
		}while(answer.equalsIgnoreCase("Yes"));
	}

}
