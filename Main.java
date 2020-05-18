package project;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		//Player p=new Player();
		system s=new system();
		Player p=new Player("mohammed","yasser","mohammedre4a@gmail.com","Alahly1907","01129550094",20180245,"Player");
		s.AddUser(p);
		s.ViewPlayers();
		Player p2=new Player("mohammed","yasser","mohammedre4a@gmail.com","Alahly1907","01129550094",20180245,"Player");
		p.Addmember(p2);
        PlayGround e=new PlayGround("01093322487","HAMADA","ALo3mrania",100,10,12345,1);
        s.Addplayground(e);
		p.Book("Hamada","Sunday 6:7",s);
		e.ViewBookedHourse();
		p.Book("Hamada","Sunday 6:7",s);
	}

}
