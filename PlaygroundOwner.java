package project;
import java.util.*;
public class PlaygroundOwner extends User {
	
	 /**
	  * Constructor
	 * @param f = First Name of User
	 * @param l=Last Name of User
	 * @param e=Email of User
	 * @param p=Password of User
	 * @param Ph=Phone number of User
	 * @param I =ID of User
	 * @param r=Role (Player,PlaygroundOwner)
	this class is used to create obj from playground inside the playground owner , so that the owenr is able to update the date of the playground
	*/
	public PlaygroundOwner(String f, String l, String e, String p, String Ph, long I, String r) {
	        super(f, l, e, p, Ph, I, r);}


	private ArrayList<PlayGround>Playgrounds= new ArrayList<PlayGround>();
	//system S;


	public void Deposit(float amount)
	{Wallet.Deposite(amount);}

}
