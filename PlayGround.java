package project;

import java.util.*;
import java.util.ArrayList;
public class PlayGround {
	ArrayList<String>BookedHours=new ArrayList<String>();
	 String Phone;
	 String Name;
	 String location;
	 float size;
	 int rentplace;
	 long  OwnerID;
	 int periodtocancel;
	 PGState playgroundstate;
	 public PlayGround( String Phone,String Name, String location, float size, int rentplace
	         , long  OwnerID, int periodtocancel)
	 {
	     this.Phone=Phone;
	     this.Name=Name;
	     this.location=location;
	     this.size=size;
	     this.OwnerID=OwnerID;
	     this.periodtocancel=periodtocancel;
	     playgroundstate=PGState.Pending;
	      }
	 public void Book(String time)
	 {
		 boolean check=false; 			//to check if this time was added before
		 for(int i=0;i<BookedHours.size();i++) {
			 if(time==BookedHours.get(i)) {
				 System.out.println("This time is not available");
				 check=true; //Found
				 break;
			 }
		 }
		 if(check==false) {
	     BookedHours.add(time);
	     System.out.println("It is Booked");}
	 }
	 public void Cancel (String time)
	 {
	     BookedHours.remove(time);
	     System.out.println("IT is Canceled");
	 }
	public void ViewBookedHourse()
	{
	    for(int i=0;i<BookedHours.size();i++)
	    {
	        System.out.println(BookedHours.get(i));
	    }
	}
	public String getName() {return Name;}

}
