package project;
import java.util.*;
/**
 * @author mohammed
 * Class contains all player's info*/
public class Player extends User {

ArrayList<Player> Team=new ArrayList<Player>();
ArrayList<String> BookingList=new ArrayList<String>();
/**Constructor*/
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
//change here
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
		int Hours;
		//withdraw money
		Wallet.Withdraw(pg.getrent());
	//s.FindOwner(pg.getOwnerID(),);
		//Deposit in PlaygroundOwner Wallet
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
    return String.format("Player name:"+FirstName+" "+LastName+" Email:"+Email+" Phone:"+Phone+" ID:"+ID); 
} 
}
