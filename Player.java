package project;
import java.util.*;
public class Player extends User {

ArrayList<Player> Team=new ArrayList<Player>();
ArrayList<String> BookingList=new ArrayList<String>();
public Player(String f, String l, String e, String p,String Ph, long I, String r) {
	super(f, l, e, p,Ph,I, r);
}
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
public void Book(String PGName,String Time,system s) {
	//Search for playground in System
	//Access playground and book
	PlayGround pg=s.FindPlayground(PGName);
	//Book this playground
	pg.Book(Time);
	//add to Booking arraylist
	BookingList.add(Time);
}
public void ViewBookedHours(String PGName,system s) {
	//Search for playground in System
		//Access playground and book
		PlayGround pg=s.FindPlayground(PGName);
		//view booked hours of pg
		pg.ViewBookedHourse();
}
public String toString() { 
    return String.format("Player name:"+FirstName+" "+LastName+" Email:"+Email+" Phone:"+Phone+" ID:"+ID); 
} 
}
