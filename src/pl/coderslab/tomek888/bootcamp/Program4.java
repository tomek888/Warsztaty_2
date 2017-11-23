package pl.coderslab.tomek888.bootcamp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program4 {

	public static void main(String[] args) {
		

		String answer="",username="", email="", password="";
		int group_id=0, exer_id=0, user_id=0;
		Solution sol1=new Solution();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		

		while(!answer.equals("quit")) {

			System.out.println("Wybierz 1 z opcji:");
			System.out.println(" add - przypisywanie zadań do użytkowników \n view - przeglądanie rozwiązań danego użytkownika \n quit - zakończenie programu  ");
			System.out.println("=====================");
			Scanner scan = new Scanner(System.in);
			answer=scan.nextLine();
			if(answer.equals("add")) {
				System.out.println("Lista urzytkowników:");
				User[] users =User.loadAll();
				for(User user:users) {
					System.out.println(user.getId()+" "+user.getUsername()+"  "+user.getEmail());
				}	
				
				System.out.println("Podaj id użytkownika");
				user_id=Integer.parseInt(scan.nextLine());
				
				System.out.println("Lista zadań:");
				Exercise[] exers =Exercise.loadAll();
				for(Exercise exer:exers) {
					System.out.println(exer.getId()+" "+exer.getTittle()+"  "+exer.getDescription());
				}	
				
				System.out.println("Podaj id zadania");
				exer_id=Integer.parseInt(scan.nextLine());
				
				sol1=new Solution(dateFormat.format(date),null,null,user_id,exer_id);
				sol1.saveToDB(0);
				
				
			}
			else if(answer.equals("view")){
				
				System.out.println("Podaj id uzytkownika, którego rozwiązania chcesz zobaczyć");
				user_id=scan.nextInt();
				Solution[] sols=Solution.loadAllByUserId(user_id);
				for(Solution sol:sols) {
					System.out.println(sol.getDescription());
				}

			}

			else {
				System.out.println("Podałeś/aś zła komende");
			}

		}
	}

}
