package project;

import java.util.ArrayList;
/**
 * @author Mariem*/
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
 /**

  * it's a contructor of PlayGround
  * @param Phone :playground Phone
  * @param Name:playground name;
  * @param location:playground location
  * @param size:palyground size
  * @param rentplace:playground rent
  * @param OwnerID: playground ownerid
  * @param periodtocancel:playground period to cancel
  * 
  * */
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
 /**
  * book time in this playground
  * @param time:to book time in playground
  * @return return true if the player book*/
 public boolean Book(String time)
 {
     boolean check=false;             //to check if this time was added before
     for(int i=0;i<BookedHours.size();i++) {
         if(time==BookedHours.get(i)) {
             System.out.println("This time is not available");
             check=true; //Found
            return false;//player has book or not??
         }
     }
     if(check==false) {
     BookedHours.add(time);
     System.out.println("It is Booked");
     }
     return true;
 }
 /**
  * to cancel the boook in playground
  * @param time:to cancel the time that has booked
  * */
 public void Cancel (String time)
 {
	 BookedHours.remove(time);
	 System.out.println("IT is Canceled");
 }
 /**
  * to view book hours in playground
  * */
public void ViewBookedHourse()
{
	for(int i=0;i<BookedHours.size();i++)
	{
		System.out.println(BookedHours.get(i));
	}
}
/**
 * to get name of  playground
 * @return Name */
public String getName() {return Name;}
/**
 * to get the rent of playground from users
 * @return rentplace*/
public int getrent()
{
	return rentplace;}
/**
 * to get the Owner ID
 * @return OwnerID
 * */
public long getOwnerID()
{
	return OwnerID;
	}

}
