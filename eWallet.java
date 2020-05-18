package project;

import java.util.*;
public class eWallet {
    float Balance;
    public void setBalance(float amt) {
        Balance=amt;
    }
    public float getBalance()
    {
        return Balance;
    }
public void Withdraw(float amt)
{if(amt>Balance) {
	System.out.println("not enough balance");
}
else {
	Balance=Balance-amt;
System.out.println(Balance);}

    }
public void Deposite(float amt)
{Balance=Balance+amt;
System.out.println(Balance);
    }
}