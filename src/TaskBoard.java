import org.exadel.task.board.dao.*;
import org.exadel.task.board.model.*;
public class TaskBoard {
	
	public static void main(String[] args){
		
		GenericDao <User,Integer> GD = new GenericDaoHibernate<User,Integer>(User.class);
		
		User u = new User();
	   
		u.setName("ghjhgj");
		
		CardList list = new CardList();
		list.setTitle("list");
		list.setU(u);
		
		GD.create(u);
	
		
		System.out.println(GD.read(new Integer(1)).toString());
		
		GenericDao<CardList,Integer> GD2 = 
				new GenericDaoHibernate<CardList,Integer> (CardList.class);
		GD2.create(list);
		
		System.out.println(GD2.read(new Integer(1)).toString());
		
		
		
		
		
	}

}
