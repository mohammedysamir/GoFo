package project;
import java.util.*;
public class ModMain {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		//Create System
		system sys=new system();
		Admin admin=new Admin("Mostafa",sys);
		//Add Admin to system
		sys.AddAdmin(admin);
		//Print Welcome Msg
		System.out.println("                                                                  *****************************");
		System.out.println("                                                                  *Welcome to GoFO Applicatoin*                       ");
		System.out.println("                                                                  *****************************");
		System.out.println(" ");
		//Sign up new User or log in
		String Continue=new String();
		do {
		System.out.println("Do you want to :");
		System.out.println("1. Sign up a new User");
		System.out.println("2. Log in");
		int PageChoice=scan.nextInt();
		switch(PageChoice) {
		case 1: //Sign up
			String FName,Lname,Email,Pass,Phone;
			long Id;
			System.out.println("1.Sign up Playground Owner.");
			System.out.println("2.Sign up Player.");
			int signupChoice=scan.nextInt();
				switch(signupChoice) {
				case 1:
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
					PlaygroundOwner Owner=new PlaygroundOwner(FName,Lname,Email,Pass,Phone,Id,"PlaygroundOwner");
					Owner.setSystem(sys);
					sys.AddUser(Owner);
					break;
				case 2:
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
					break;
					default:System.out.println("Invalid Choice");
					break;
				}//2nd switch
			break;
		case 2://Log in
			String email,pass;
			System.out.println("Enter Email and Password");
			email=scan.next();
			pass=scan.next();
			//Scan in data base to find out what is his role
			String Accept=new String("Yes");
			String Found=sys.SearchinDB(email, pass);
			if(Found.equalsIgnoreCase("PlaygroundOwner")) {
				//Owner Menu;
				PlaygroundOwner owner=sys.Owner(email, pass);
				if(owner==null)System.out.println("Null");
				 while(Accept.equalsIgnoreCase("Yes")) {//to loop through same menu
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
							PlayGround pg=new PlayGround(pgphone,pgname,pglocation,Size,Rent,owner.getID(),ptoCancel);
							owner.RegisterPlayground(pg);
						}
						if(OwnerChoice==2) {
							owner.ViewBookedHours();
						}
						if(OwnerChoice==3) {
							System.out.println(owner.checkbalance());
						}
						System.out.println("If you want to continue as playground(s) Owner type Yes");	
						Accept=scan.next();
						}
			}
			else if(Found.equalsIgnoreCase("Player")) {
				//Player menu
				while(Accept.equalsIgnoreCase("Yes")) {//to loop through same menu
					Player player=sys.player(email, pass);	 
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
						//Add player by his Email
						System.out.println("Enter member's email");
						String FriendEmail=scan.next();
						Player member=sys.player(FriendEmail);
						player.Addmember(member);
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
					Accept=scan.next();
				 }
			}
			break;
			default: System.out.println("Invalid");
			break;
		}
		System.out.println("******************************************************");
		System.out.println("Do you want to continue or close, Type Yes to continue");
		System.out.println("******************************************************");
		Continue=scan.next();
		}while(Continue.equalsIgnoreCase("Yes"));
		scan.close();
	}
	
}
