package pl.coderslab.tomek888.bootcamp;

import java.util.Scanner;

public class Program3 {

	public static void main(String[] args) {

		String answer="",name;
		int group_id=0, delete_id=0, usergroup_id;
		Scanner scan = new Scanner(System.in);
		User_group user1=new User_group();

		
		while(!answer.equals("quit")) {
			System.out.println("Lista grup:");
			User_group[] users =User_group.loadAll();
			for(User_group user:users) {
				System.out.println(user.getname());
			}
			System.out.println("=====================");
			System.out.println("Wybierz 1 z opcji:");
			System.out.println(" add - dodawanie grupy \n edit - edycja grupy \n delete - usunięcie grupy \n quit - zakończenie programu  ");
			System.out.println("=====================");
			answer=scan.nextLine();
			
			if(answer.equals("add")) {
				System.out.println("Podaj nazwę grupy");
				name=scan.nextLine();
				
				user1=new User_group(name);
				user1.saveToDB(0);
				
				
			}
			else if(answer.equals("edit")){
				
				System.out.println("Podaj id zadania do edycji");
				usergroup_id=Integer.parseInt(scan.nextLine());
				System.out.println("Podaj nazwę grupy");
				name=scan.nextLine();
				
				user1.setname(name);
				user1.saveToDB(usergroup_id);

			}
			else if(answer.equals("delete")){
				System.out.println("Podaj id grupy usunięcia");
				delete_id=Integer.parseInt(scan.nextLine());
				User_group.deleteById(delete_id);

			}
			else {
				System.out.println("Podałeś/aś zła komende");
			}

		}
	}

}
