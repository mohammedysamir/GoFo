package project;

import java.util.ArrayList;
/**
 * @author mohammed
 * system class that controls this application*/
public class system {
	 private ArrayList<Admin> Admins=new ArrayList<Admin>();
	 private ArrayList<Player> Players=new ArrayList<Player>();
	 private ArrayList<PlaygroundOwner> Owners=new ArrayList<PlaygroundOwner>();
	 private ArrayList<PlayGround> Playgrounds=new ArrayList<PlayGround>();
	 /**
	  * @param p = Player object
	  * Add Player to the system
	  * */
	public void AddUser(Player p) {
		boolean checker=false;
		for(int i=0;i<Players.size();i++) {// check if this id is there before
		if(p.getID()==Players.get(i).getID()) {
			checker=true;
			break;
			}
		}
		if(checker==false) {
		Players.add(p);
		System.out.println("Player is Added"); }
		Approve(p);
		
	} 
	 /**
	  * @param p = Player object
	  * Delete Player from the system
	  * */
	public void DeleteUser(Player p) {  //Delete User by ID
		for(int i=0;i<Players.size();i++) {
			if(Players.get(i).getID()==p.getID())
			{
				Players.remove(i);
				System.out.println("Player is Removed");
				}
			}
		}
	 /**
	  * View all players in the system 
	  * */
	public void ViewPlayers() {	//Loop through Users
		for(int i=0;i<Players.size();i++) {
			System.out.println(Players.get(i).toString());
			}
		}
	/**
	  * View all playgrounds in the system 
	  * */
	public void ViewPlaygrounds() { //Loop through Playgrounds
		for(int i=0;i<Playgrounds.size();i++) {
			System.out.println(Playgrounds.get(i));
			}
		}
	/**
	 * @param a: Admin object
	 * Add admin to the system
	 * */
	public void AddAdmin(Admin a) {		//Add admin to arraylist
		Admins.add(a);
		System.out.println("Admin Added");
		}
	/**
	 * @param p: Playground object
	 * Add Playground to the system
	 * */
	public void Addplayground(PlayGround p) {//Add Playground to arraylist
		Admins.get(0).Verify(p);		//Verify playground 
		Playgrounds.add(p);
		System.out.println("Playground is Added");
	}
	/**
	 * @param p: Playground object
	 * Delete Playground to the system
	 * */
	public void Deleteplayground(PlayGround p) { //Delete Playground by name may be by OwnerID too
		for(int i=0;i<Playgrounds.size();i++) {
			if(Playgrounds.get(i).getName()==p.getName())
			{
				Playgrounds.remove(i);
				System.out.println("playground is Removed");
				}
			}
	}
	public void Approve(Player p) {p.State=UserState.Approved;}
	public void Approve(PlaygroundOwner o) {o.State=UserState.Approved;}
	/**
	 * @param p:PlayGround object
	 * Approve PlayGround and change its state to Active*/
	public void Approve(PlayGround p) {p.playgroundstate=PGState.Active;}
	/**
	 * @param o:PlaygroundOwner object
	 * Add PlaygroundOwner to the system*/
	public void AddUser(PlaygroundOwner o) {
		boolean checker=false;
		for(int i=0;i<Owners.size();i++) {// check if this id is there before
		if(o.getID()==Owners.get(i).getID()) {
			checker=true;
			break;
			}
		}
		if(checker==false) {
		Owners.add(o);
		System.out.println("Owner is Added"); }
		Approve(o);
	} 
	/**
	 * @param o: PlaygroundOwner object
	 * Delete Owner from system*/
	public void DeleteUser(PlaygroundOwner o) {  //Delete Owner by ID
		for(int i=0;i<Players.size();i++) {
			if(Owners.get(i).getID()==o.getID())
			{
				Owners.remove(i);
				System.out.println("Owner is Removed");
				}
			}
		}
	/**
	 * View all owners in the system*/
	public void ViewOwners() {	//Loop through Owners
		for(int i=0;i<Owners.size();i++) {
			System.out.println(Owners.get(i));
			}
		}
	/**
	 * @param Name: Name of PlayGround+
	 * Find specific PlayGround by its name
	 * return PlayGround*/
	public PlayGround FindPlayground(String Name) {
		boolean check=false;
		for(int i=0;i<Playgrounds.size();i++) {
			if(Playgrounds.get(i).getName()==Name)
				check=true;
				return Playgrounds.get(i);
			}
		if(check==false)
			System.out.println("this playground isn't found");
		return Playgrounds.get(0);
	}
	/**
	 * @param id:Owner ID
	 * @param amount :amount to be paid
	 * Find Owner with specific id
	 * */
	public void FindOwner(long id, float amount) {
		boolean checker=false;		//check if we found Owner
		for(int i=0;i<Owners.size();i++) {//find Owner
			if(id==Owners.get(i).getID()) {
				checker=true;		//Found
				// Owners.get(i).Deposit(amount);
			}
		}
		if(checker==false)
			System.out.println("Owner Not Found");
		
	}
}
