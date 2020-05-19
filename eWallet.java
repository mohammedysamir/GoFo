package project;
/**
 * @author Mariem*/
public class eWallet {
	float Balance;
	/**
	 * to set the balance  of the user to book the playground
	 * @param amt:the palyground have the rent from the user*/
	public void setBalance(float amt) {
		Balance=amt;
	}
	/**
	 *to get the balance of the user*/
	public float getBalance()
	{
		return Balance;
	}
	/**
	 * the user want to withdrow his money to pay to book the palyground
	 * @param amt:the amount that user want to book the playground*/
public void Withdraw(float amt)
{if(amt>Balance) {
    System.out.println("not enough balance");
}
else {
    Balance=Balance-amt;
System.out.println(Balance);}
	
	}
/**
 * to deposite the balance of user
 * @param amt:the user set the amount and increase his balance */
public void Deposite(float amt)
{Balance=Balance+amt;
System.out.println(Balance);
	}
}
