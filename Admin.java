package project;

public class Admin {
	String Name;
	system S;
	/**
	 * Constructor
	 * @param n:Name
	 * @param sys: System of the admin*/
	public Admin(String n,system sys) {
		Name=n;
		S=sys;
	}
	/**
	*@param pg : used to create object from playground 
	*this function is used to change the state of playground from suspended or from pending to Activate
	*/
	public void Active(PlayGround pg){
	if(pg.playgroundstate==PGState.Suspended || pg.playgroundstate==PGState.Pending)//if suspended or pending active it
	{pg.playgroundstate=PGState.Active;
	System.out.println("Playgound is Activated");
	}

	else if(pg.playgroundstate==PGState.Deleted)//if deleted you can
	System.out.println("Playgound is Deleted ,Can not be activated ");

	else		//already Active
	System.out.println("Playgound is already activated.");
}

	/**
	@param pg : used to create object from playground 
	this function is used to change the state of the playgound to suspended when it breaks the rules
	*/

	public void Suspended(PlayGround pg)
	{pg.playgroundstate=PGState.Suspended;
	System.out.println("Playgound is Suspended");}

	/**
	@param pg : used to create object from playground 
	this function is used to delet the playgorund from the system when it is not avilable
	*/

	public void Deleted (PlayGround pg)
	{pg.playgroundstate=PGState.Deleted;
	S.Deleteplayground(pg);
	System.out.println("This playground has been deleted from system");
	}

	/**
	@param pg : used to create object from playground 
	this function is use to change the state of the playgorund from  pending to Verfyied(Activated)

	*/

	public void Verify(PlayGround pg)
	{pg.playgroundstate=PGState.Active;
	System.out.println("Playgound is  activated.");
	}

}
