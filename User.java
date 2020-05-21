package project;
 /** 
  * @author mohammed
  * this class contains User info
  * */

public class User {
String FirstName;
String LastName;
String Email;
String Phone;
String Password;
long ID;
eWallet Wallet=new eWallet();
String Role;
UserState State;
/** 
 * @param f = First Name of User
 * @param l=Last Name of User
 * @param e=Email of User
 * @param p=Password of User
 * @param Ph=Phone number of User
 * @param I =ID of User
 * @param r=Role (Player,PlaygroundOwner)*/
public User(String f,String l,String e,String p,String Ph, long I,String r) {
	FirstName=f;
	LastName=l;
	Email=e;
	Password=p;
	Phone=Ph;
	ID=I;
	Role=r;
	//State=UserState.Pending;
			}
/**
 * @return return ID of User*/
public long getID() {
	return ID;
		}
/**
 * @return User's Balance*/
public 	float checkbalance() {
	return Wallet.getBalance();
		}

}
