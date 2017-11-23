package pl.coderslab.tomek888.bootcamp;

import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) {

		String answer="",title, description;
		int group_id=0, delete_id=0, ex_id;
		Scanner scan = new Scanner(System.in);
		Exercise ex1=new Exercise();

		
		while(!answer.equals("quit")) {
			System.out.println("Lista zadań:");
			Exercise[] exers =Exercise.loadAll();
			for(Exercise exer:exers) {
				System.out.println(exer.getTittle()+"  "+exer.getDescription());
			}	
			System.out.println("=====================");
			System.out.println("Wybierz 1 z opcji:");
			System.out.println(" add - dodawanie zadania \n edit - edycja zadania \n delete - usunięcie zadania \n quit - zakończenie programu  ");
			System.out.println("=====================");
			answer=scan.nextLine();
			
			if(answer.equals("add")) {
				System.out.println("Podaj tytuł zadania");
				title=scan.nextLine();
				System.out.println("Podaj opis zadania");
				description=scan.nextLine();
				ex1=new Exercise(title, description);
				ex1.saveToDB(0);
				
				
			}
			else if(answer.equals("edit")){
				
				System.out.println("Podaj id zadania do edycji");
				ex_id=Integer.parseInt(scan.nextLine());
				System.out.println("Podaj tytuł zadania");
				title=scan.nextLine();
				System.out.println("Podaj opis zadania");
				description=scan.nextLine();
				ex1.setTittle(title).setDescription(description);
				ex1.saveToDB(ex_id);

			}
			else if(answer.equals("delete")){
				System.out.println("Podaj id zadania do usunięcia");
				delete_id=Integer.parseInt(scan.nextLine());
				Exercise.deleteById(delete_id);

			}
			else {
				System.out.println("Podałeś/aś zła komende");
			}

		}
	}

}
