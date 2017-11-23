package pl.coderslab.tomek888.bootcamp;

import java.util.Scanner;

public class Program1 {

	public static void main(String[] args) {

		String answer="",username="", email="", password="";
		int group_id=0, delete_id=0, user_id=0;
		User user1=new User();

		while(!answer.equals("quit")) {
			System.out.println("Lista urzytkowników:");
			User[] users =User.loadAll();
			for(User user:users) {
				System.out.println(user.getUsername()+"  "+user.getEmail());
			}	
			System.out.println("=====================");
			System.out.println("Wybierz 1 z opcji:");
			System.out.println(" add - dodawanie użytkownika \n edit - edycja użtkownika \n delete - usunięcie użytkownika \n quit - zakończenie programu  ");
			System.out.println("=====================");
			Scanner scan = new Scanner(System.in);
			answer=scan.next();
			if(answer.equals("add")) {
				System.out.println("Podaj nazwę uzytkownika");
				username=scan.next();
				System.out.println("Podaj adres email");
				email=scan.next();
				System.out.println("Podaj hasło");
				password=scan.next();
				System.out.println("Podaj id grupy");
				group_id=scan.nextInt();
				user1=new User(username, email,password,group_id);
				user1.saveToDB(0);
				
				
			}
			else if(answer.equals("edit")){
				
				System.out.println("Podaj id uzytkownika do edycji");
				user_id=scan.nextInt();
				System.out.println("Podaj nazwę uzytkownika");
				username=scan.next();
				System.out.println("Podaj adres email");
				email=scan.next();
				System.out.println("Podaj hasło");
				password=scan.next();
				System.out.println("Podaj id grupy");
				group_id=scan.nextInt();
				user1.setUsername(username).setEmail(email).setPassword(password).setGroup_id(group_id);
				user1.saveToDB(user_id);

			}
			else if(answer.equals("delete")){
				System.out.println("Podaj id uzytkownika do usunięcia");
				delete_id=scan.nextInt();
				User.deleteById(delete_id);

			}
			else {
				System.out.println("Podałeś/aś zła komende");
			}

		}
	}

}
