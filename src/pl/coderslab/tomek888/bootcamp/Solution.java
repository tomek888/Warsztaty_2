package pl.coderslab.tomek888.bootcamp;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Solution {

	
	private int id = 0;
	private String created;
	private String updated;
	private String description;
	private int user_id;
	private int exercise_id;
	
	public Solution (String created, String updated, String description,int user_id, int exercise_id) {
		setCreated(created);
		setUpdated(updated);
		setDescription(description);
		setUser_id(user_id);
		setExercise_id(exercise_id);
	}
	public Solution() {
		
	}

	public String getCreated() {
		return created;
	}

	public Solution setCreated(String created) {
		this.created =  created;
		return this;
	}

	public String getUpdated() {
		return updated;
	}

	public Solution setUpdated(String updated) {
		this.updated = updated;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Solution setDescription(String description) {
		this.description = description;
		return this;
	}
	
	
	public int getUser_id() {
		return user_id;
	}

	public Solution setUser_id(int user_id) {
		this.user_id = user_id;
		return this;
	}

	public int getExercise_id() {
		return exercise_id;
	}

	public Solution setExercise_id(int exercise_id) {
		this.exercise_id = exercise_id;
		return this;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}
	
	
	public void saveToDB(int a) {
		if ( this.id == 0 ) {
			addToDB();
		}else {
			updateInDB(a);
		}
	}
	
	private void addToDB() {
		
		String query = "Insert into solution Values (null, ?, ?, ?, ?, ?);";
		String[] params = { getCreated(),getUpdated(), getDescription(),Integer.toString(getUser_id()), Integer.toString(getExercise_id()) };
		int newId = DbClient.insertData(query, params);
		if(newId != 0) {
			setId(newId);
		}
		
	}
	
	private void updateInDB(int a) {
		
		String query = "Update Solutions set created = ?, description = ?, updated = ? user_id = ?, exercise_id = ? where id = ?";
		String[] params = {getCreated(), getDescription(), getUpdated(), Integer.toBinaryString(getUser_id()), Integer.toBinaryString(getExercise_id()), Integer.toString(a) };
		
		DbClient.updateData(query, params);
		
	}
	
	
	public static Solution[] loadAll() {
		
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		
		String query = "Select * from solution;";
		
		try {
			ResultSet rs = DbClient.getData(query, new String[0]);
			
			while (rs.next()) {
				Solution tmpSolution = new Solution(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
				tmpSolution.id = rs.getInt(1);
				tmpSolution.created = rs.getString(2);
				tmpSolution.updated = rs.getString(3);
				tmpSolution.description = rs.getString(4);
				solutions.add(tmpSolution);
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbClient.closeConnection();
		}
		
		
		Solution[] SolutionsArr = new Solution[solutions.size()];
		SolutionsArr = solutions.toArray(SolutionsArr);
		
		return SolutionsArr;
		
	}
	
	public static Solution loadOneById(int id) {
		
		
		String query = "Select * from solution where id = ?;";
		String[] params = { Integer.toString(id) };
		
		Solution Solution = null;
		
		try {
			ResultSet rs = DbClient.getData(query, params);
			
			if (rs.next()) {
				Solution = new Solution(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
				Solution.id = rs.getInt(1);
				Solution.created = rs.getString(2);
				Solution.updated = rs.getString(3);
				Solution.updated = rs.getString(4);
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbClient.closeConnection();
		}
		
		return Solution;
		
	}
	
	public static void deleteById(int id) {
		
		String query = "Delete from solution where id = ?";
		String[] params = { Integer.toString(id) };
		
		DbClient.deleteData(query, params);
		
	}
	
	public static Solution[] loadAllByExerciseId(int id) {
		String query = "Select * from solution JOIN exercise ON exercise.id=solution.exercise_id where solution.exercise_id = ?;";
		String[] params = { Integer.toString(id) };
		ArrayList<Solution> Solutions = new ArrayList<Solution>();
		
		
		
		try {
			ResultSet rs = DbClient.getData(query, params);
			
			while (rs.next()) {
				Solution tmpExercise = new Solution();
				tmpExercise.id = rs.getInt(1);
				tmpExercise.description = rs.getString(4);
				Solutions.add(tmpExercise);
			
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbClient.closeConnection();
		}
		
		
		Solution[] SolutionsArr = new Solution[Solutions.size()];
		SolutionsArr = Solutions.toArray(SolutionsArr);
		
		return SolutionsArr;
	}
		public static Solution[] loadAllByUserId(int id) {
		String[] params = { Integer.toString(id) };
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		
		String query = "Select * from solution where users_id = ?;";
		
		try {
			ResultSet rs = DbClient.getData(query, params);
			
			while (rs.next()) {
				Solution tmpSolution = new Solution(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
				tmpSolution.id = rs.getInt(1);
				tmpSolution.created = rs.getString(2);
				tmpSolution.updated = rs.getString(3);
				tmpSolution.description = rs.getString(4);
				solutions.add(tmpSolution);
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbClient.closeConnection();
		}
		
		
		Solution[] SolutionsArr = new Solution[solutions.size()];
		SolutionsArr = solutions.toArray(SolutionsArr);
		
		return SolutionsArr;
		
	}
		
	
	
}
