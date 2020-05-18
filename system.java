package project;

import java.util.ArrayList;

public class system {
	 private ArrayList<Admin> Admins=new ArrayList<Admin>();
	 private ArrayList<Player> Players=new ArrayList<Player>();
	 private ArrayList<PlaygroundOwner> Owners=new ArrayList<PlaygroundOwner>();
	 private ArrayList<PlayGround> Playgrounds=new ArrayList<PlayGround>();
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
		//p.State=UserState.Approved;
		
	} 
	public void DeleteUser(Player p) {  //Delete User by ID
		for(int i=0;i<Players.size();i++) {
			if(Players.get(i).getID()==p.getID())
			{
				Players.remove(i);
				System.out.println("Player is Removed");
				}
			}
		}
	public void ViewPlayers() {	//Loop through Users
		for(int i=0;i<Players.size();i++) {
			System.out.println(Players.get(i).toString());
			}
		}
	public void ViewPlaygrounds() { //Loop through Playgrounds
		for(int i=0;i<Playgrounds.size();i++) {
			System.out.println(Playgrounds.get(i));
			}
		}
	public void AddAdmin(Admin a) {		//Add admin to arraylist
		Admins.add(a);
		System.out.println("Admin Added");
		}
	public void Addplayground(PlayGround p) {//Add Playground to arraylist
		Playgrounds.add(p);
		System.out.println("Playground is Added");
	}
	
	public void Deleteplayground(PlayGround p) { //Delete Playground by name may be by OwnerID too
		for(int i=0;i<Playgrounds.size();i++) {
			if(Playgrounds.get(i).getName()==p.getName())
			{
				Playgrounds.remove(i);
				System.out.println("playground is Removed");
				}
			}
	}
	//public void Approve(Player p) {p.State=UserState.Approved;}
	//public void Approve(PlaygroundOwner o) {o.State=UserState.Approved;}
	public void Approve(PlayGround p) {p.playgroundstate=PGState.Active;}
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
		//p.State=UserState.Approved;
	} 
	public void DeleteUser(PlaygroundOwner o) {  //Delete Owner by ID
		for(int i=0;i<Players.size();i++) {
			if(Owners.get(i).getID()==o.getID())
			{
				Owners.remove(i);
				System.out.println("Owner is Removed");
				}
			}
		}
	public void ViewOwners() {	//Loop through Owners
		for(int i=0;i<Owners.size();i++) {
			System.out.println(Owners.get(i));
			}
		}
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
}
