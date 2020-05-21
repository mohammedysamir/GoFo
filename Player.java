package project;
import java.util.*;
/**
 * @author mohammed
 * Class contains all player's info*/
public class Player extends User {

ArrayList<Player> Team=new ArrayList<Player>();
ArrayList<String> BookingList=new ArrayList<String>();
/**Constructor
 * 
 * @param f = First Name of User
 * @param l=Last Name of User
 * @param e=Email of User
 * @param p=Password of User
 * @param Ph=Phone number of User
 * @param I =ID of User
 * @param r=Role (Player,PlaygroundOwner)*/
public Player(String f, String l, String e, String p,String Ph, long I, String r) {
	super(f, l, e, p,Ph,I, r);
}
/**@param p: Player object
 * Add member to Player's team*/
public void Addmember(Player p) {
	//check if this team member was added before
	boolean checker=false;
	for(int i=0;i<Team.size();i++) {
		if(p.getID()==Team.get(i).getID())
		{
			checker=true;
			System.out.println("This member added before");
			break;
		}
	}
	if(checker==false) {
		Team.add(p);
		System.out.println("member is added");
		}
	}
/**
 * @param PGName : PlayGround Name
 * @param Time: Hour slot(s) to reserve
 * @param s: System object
 * Function to book Hour slot(s) in cetain playground*/
public void Book(String PGName,String Time,system s) {
	//Search for playground in System
	//Access playground and book
	PlayGround pg=s.FindPlayground(PGName);
	//Book this playground
	if(pg.Book(Time)) {
		//Determine how many hours
		int index=0;
		for(int i=0;i<Time.length();i++) {
			if(Time.charAt(i)==':') {
				index=i;
			}
		}
		if(index ==0)System.out.println("Invalid time syntax");
		String from=String.valueOf(Time.charAt(index-1));		//convert char to string
		String to=String.valueOf(Time.charAt(index+1));			//convert char to string
		int Hours=Integer.parseInt(to)-Integer.parseInt(from); //Get number of Hours
		int RentValue=Hours*pg.getrent();				//Get Price to pay
		//withdraw money
		Wallet.Withdraw(RentValue);			//withdraw from Player
		//Deposit in PlaygroundOwner Wallet
		
		s.FindOwner(pg.getOwnerID(),RentValue);		//Deposit to Owner
		
		//add to Booking arraylist
		BookingList.add(Time);
	}
	else {
		System.out.println("You cant reserve this time");
	}
	
}
/**
 * @param PGName: Playground name
 * @param s: System object
 * Function to show BookedHours of playground*/
public void ViewBookedHours(String PGName,system s) {
	//Search for playground in System
		//Access playground and book
		PlayGround pg=s.FindPlayground(PGName);
		//view booked hours of pg
		pg.ViewBookedHourse();
}
/**
 * Override to toString function to show player's info*/
public String toString() { 
    return String.format(" Player name:"+FirstName+" "+LastName+"\n"+" Email:"+Email+"\n"+" Phone:"+Phone+"\n"+" ID:"+ID); 
} 
}
