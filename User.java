package project;
import java.util.*;
public class User {
String FirstName;
String LastName;
String Email;
String Phone;
String Password;
long ID;
eWallet Wallet;
String Role;
UserState State;
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
public long getID() {
	return ID;
		}
public 	float checkbalance() {
	return Wallet.getBalance();
		}

}
