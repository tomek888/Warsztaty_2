package pl.coderslab.tomek888.bootcamp;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
//		String db_name = "Bootcamp";
//		
//		Init.createDB(db_name);
//	
//		DbClient.db_name = db_name;
//		try {
//			Init.createTables();
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
//		User[] users =User.loadAllByGrupId(2);
//		for(User user:users) {
//			System.out.println(user.getUsername());
//		}	
//		
		
//		Solution[] sols =Solution.loadAllByExerciseId(1);
//		for(Solution sol:sols) {
//			System.out.println(sol.getDescription());
//		}		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String date2 =dateFormat.format(date);
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		//System.out.println("saasas");
		
		
//		Exercise[] exers =Exercise.loadAllByUserId(1);
//		for(Exercise exer:exers) {
//			System.out.println(exer.getTittle());
//		}
		
		
		
		
//		Solution sol1=new Solution("2017-10-23 15:24:00", "2017-10-23 17:46:00","add external library",1,1);
//		sol1.saveToDB();
//		Solution sol2=new Solution("2017-10-24 11:21:00", "2017-10-25 22:16:00","remove method Divide",1,1);
//		sol2.saveToDB();
//		Solution sol3=new Solution("2017-11-03 18:35:00", "2017-11-06 14:22:00","check all your variables",4,2);
//		sol3.saveToDB();
//		Solution[] sols =Solution.loadAll();
//		for(Solution sol:sols) {
//			System.out.println(sol.getDescription());
//		}
//		Solution sol=Solution.loadOneById(2);
//		System.out.println(sol.getDescription());
//		Solution.deleteById(1);
		
		
//		User_group us1=new User_group("JAVA Web");
//		us1.saveToDB();
//		User_group us2=new User_group("HTML i CSS");
//		us2.saveToDB();
//		User_group us3=new User_group("PHP");
//		us3.saveToDB();
//		User_group[] users =User_group.loadAll();
//		for(User_group user:users) {
//			System.out.println(user.getname());
//		}
//		User_group user=User_group.loadOneById(3);
//		System.out.println(user.getname());
//		User_group.deleteById(3);
		
		

//		Exercise ex1=new Exercise("loops", "for and while");
//		ex1.saveToDB();
//		Exercise ex2=new Exercise("loops ", "if and case");
//		ex2.saveToDB();
//		Exercise ex3=new Exercise("strings ", "concat and trim");
//		ex3.saveToDB();
//		Exercise[] exers =Exercise.loadAll();
//		for(Exercise exer:exers) {
//			System.out.println(exer.getTittle());
//		}
//		Exercise exer=Exercise.loadOneById(3);
//		System.out.println(exer.getTittle());
//		Exercise.deleteById(3);
		
		
		
//		User[] users =User.loadAll();
//		for(User user:users) {
//			System.out.println(user.getUsername());
//		}
//
	
		
//		User user=User.loadOneById(3);
//		System.out.println(user.getUsername());
//		User.deleteById(3);

	}
	
	
	

}
