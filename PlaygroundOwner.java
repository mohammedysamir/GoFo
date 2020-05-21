package project;
import java.util.*;
public class PlaygroundOwner extends User {
	
	 /**
	 * 
	 * @param f = First Name of User
	 * @param l=Last Name of User
	 * @param e=Email of User
	 * @param p=Password of User
	 * @param Ph=Phone number of User
	 * @param I =ID of User
	 * @param r=Role (Player,PlaygroundOwner)
	this class is used to create object from playground inside the playground owner , so that the owner is able to update the date of the playground
	*/
	public PlaygroundOwner(String f, String l, String e, String p, String Ph, long I, String r) {
	        super(f, l, e, p, Ph, I, r);}
	
	private ArrayList<PlayGround>Playgrounds= new ArrayList<PlayGround>();
	private system S;
/**
 * View Booked Hours for all playground belongs to this Owner*/
	public void ViewBookedHours() {
		if(Playgrounds.size()==0) {System.out.println("No registed playgrounds yet.");}
		for(int i=0;i<Playgrounds.size();i++) {
			Playgrounds.get(i).ViewBookedHourse();
		}
	}
	/**@param amount: amount to be deposit
	 * To deposit amount of money into Owner's Wallet*/
	public void Deposit(float amount)
	{	Wallet.Deposite(amount);}
	/**
	 * @param sys: initialize system for Owner
	 * To initialize to specific Owner
	 * */
	public void setSystem(system sys) {S=sys;}
	/**@param pg : object of Playground
	 * To register playground
	 * */
	public void RegisterPlayground(PlayGround pg) {
		Playgrounds.add(pg);
		S.Addplayground(pg);
		System.out.println("Playground has been added");
	}
}
