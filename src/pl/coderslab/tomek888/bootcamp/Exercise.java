package pl.coderslab.tomek888.bootcamp;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Exercise {

	
	private int id = 0;
	private String tittle;
	private String description;
	
	public Exercise ( String tittle, String description) {
		
		setTittle(tittle);
		setDescription(description);
	}
	public Exercise () {
		
	}

	
	
	public String getTittle() {
		return tittle;
	}



	public Exercise setTittle(String tittle) {
		this.tittle = tittle;
		return this;
	}



	public String getDescription() {
		return description;
	}



	public Exercise setDescription(String description) {
		this.description = description;
		return this;
	}



	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}
	
	
	public void saveToDB(int a) {
		if (( this.id == 0 )&&(a==0)) {
			addToDB();
		}else {
			updateInDB(a);
		}
	}
	
	private void addToDB() {
		
		String query = "Insert into exercise Values (null, ?, ?);";
		String[] params = {  getTittle(),getDescription() };
		int newId = DbClient.insertData(query, params);
		if(newId != 0) {
			setId(newId);
		}
		
	}
	
	private void updateInDB(int a) {
		
		
		String query = "Update exercise set title = ?, description = ?  where id = ?";
		String[] params = { getTittle(), getDescription(), Integer.toString(a) };
		
		DbClient.updateData(query, params);
		
	}
	
	
	public static Exercise[] loadAll() {
		
		ArrayList<Exercise> Exercises = new ArrayList<Exercise>();
		
		String query = "Select * from exercise;";
		
		try {
			ResultSet rs = DbClient.getData(query, new String[0]);
			
			while (rs.next()) {
				Exercise tmpExercise = new Exercise(rs.getString(2),rs.getString(3));
				tmpExercise.id = rs.getInt(1);
				tmpExercise.tittle = rs.getString(2);
				Exercises.add(tmpExercise);
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbClient.closeConnection();
		}
		
		
		Exercise[] ExercisesArr = new Exercise[Exercises.size()];
		ExercisesArr = Exercises.toArray(ExercisesArr);
		
		return ExercisesArr;
		
	}
	
	public static Exercise loadOneById(int id) {
		
		
		String query = "Select * from exercise where id = ?;";
		String[] params = { Integer.toString(id) };
		
		Exercise Exercise = null;
		
		try {
			ResultSet rs = DbClient.getData(query, params);
			
			if (rs.next()) {
				Exercise = new Exercise(rs.getString(2),rs.getString(3));
				Exercise.id = rs.getInt(1);
				Exercise.tittle = rs.getString(2);
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbClient.closeConnection();
		}
		
		return Exercise;
		
	}
	
	public static void deleteById(int id) {
		
		String query = "Delete From exercise where id = ?";
		String[] params = { Integer.toString(id) };
		
		DbClient.deleteData(query, params);
		
	}
	
	public static Exercise[] loadAllByUserId(int id) {
		String query = "Select * from exercise JOIN solution ON exercise.id=solution.exercise_id JOIN users ON users.id=solution.users_id  where solution.users_id = ?;";
		String[] params = { Integer.toString(id) };
		ArrayList<Exercise> Exercises = new ArrayList<Exercise>();
		
		
		
		try {
			ResultSet rs = DbClient.getData(query, params);
			
			while (rs.next()) {
				Exercise tmpExercise = new Exercise(rs.getString(2),rs.getString(3));
				tmpExercise.id = rs.getInt(1);
				tmpExercise.tittle = rs.getString(2);
				Exercises.add(tmpExercise);
			
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbClient.closeConnection();
		}
		
		
		Exercise[] ExercisesArr = new Exercise[Exercises.size()];
		ExercisesArr = Exercises.toArray(ExercisesArr);
		
		return ExercisesArr;
		
	}
		
	
	
}
