package pl.coderslab.tomek888.bootcamp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Program5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String answer="",solution;
		int exer_id=0, user_id=0, id=0;
		Solution sol1=new Solution();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		

		System.out.println("Podaj swój nr ID");
		user_id=Integer.parseInt(scan.nextLine());

		while(!answer.equals("quit")) {

			System.out.println("Wybierz 1 z opcji:");
			System.out.println(" add - przypisywanie zadań do użytkowników \n view - przeglądanie rozwiązań danego użytkownika \n quit - zakończenie programu  ");
			System.out.println("=====================");

			answer=scan.nextLine();
			if(answer.equals("add")) {
				Solution[] sols =Solution.loadAll();
				int[] user_ids = new int[sols.length];
				int[] exer_ids = new int[sols.length];
				int i=0;
				for(Solution sol:sols) {
					user_ids[i]=sol.getUser_id();
					exer_ids[i]=sol.getExercise_id();

					i++;
				}
				System.out.println("=====================");
				Exercise[] exers =Exercise.loadAll();

				for(Exercise exer:exers) {

				}
				for(Exercise exer:exers) {
					boolean check_exer=false;
					for(int j=0;j<sols.length;j++) {
						if((exer.getId()==exer_ids[j])&&(user_id==user_ids[j])) {
							check_exer=true;
						}
					}
					if(check_exer==false) {
						System.out.println(exer.getId()+" "+exer.getTittle());
					}
				}
				System.out.println("Podaj ID zadadnia, do ktorego chesz dodać rozwiązanie");
				id=Integer.parseInt(scan.nextLine());
				System.out.println("Podaj rozwiązanie");
				solution=scan.nextLine();
				sol1=new Solution(null,dateFormat.format(date),solution,user_id,id);
				sol1.saveToDB(0);
				

			}
			else if(answer.equals("view")){

				System.out.println("Lista Twoich rozwiązań:");
				Solution[] sols=Solution.loadAllByUserId(user_id);
				for(Solution sol:sols) {
					System.out.println("* "+sol.getDescription());
				}

			}
			else if(answer.equals("quit")) {

			}

			else {
				System.out.println("Podałeś/aś zła komende");
			}
			System.out.println("=====================");

		}
	}



}
