package pl.coderslab.tomek888.bootcamp;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User_group {

	
	private int id = 0;
	private String name;
	
	
	public User_group (String name) {
		setname(name);
		
	}
	
	public User_group() {
		
	}

	public String getname() {
		return name;
	}

	public User_group setname(String name) {
		this.name =  name;
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
		
		String query = "Insert into user_group Values (null, ?);";
		String[] params = { getname()};
		int newId = DbClient.insertData(query, params);
		if(newId != 0) {
			setId(newId);
		}
		
	}
	
	private void updateInDB(int a) {
		
		String query = "Update user_group set name = ? where id = ?";
		String[] params = {getname(), Integer.toString(a) };
		
		DbClient.updateData(query, params);
		
	}
	
	
	public static User_group[] loadAll() {
		
		ArrayList<User_group> users = new ArrayList<User_group>();
		
		String query = "Select * from user_group;";
		
		try {
			ResultSet rs = DbClient.getData(query, new String[0]);
			
			while (rs.next()) {
				User_group tmpUser = new User_group(rs.getString(2));
				tmpUser.id = rs.getInt(1);
				users.add(tmpUser);
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbClient.closeConnection();
		}
		
		
		User_group[] usersArr = new User_group[users.size()];
		usersArr = users.toArray(usersArr);
		
		return usersArr;
		
	}
	
	public static User_group loadOneById(int id) {
		
		
		String query = "Select * from user_group where id = ?;";
		String[] params = { Integer.toString(id) };
		
		User_group user = null;
		
		try {
			ResultSet rs = DbClient.getData(query, params);
			
			if (rs.next()) {
				user = new User_group(rs.getString(2));
				user.id = rs.getInt(1);
				
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbClient.closeConnection();
		}
		
		return user;
		
	}
	
	public static void deleteById(int id) {
		
		String query = "Delete From user_group where id = ?";
		String[] params = { Integer.toString(id) };
		
		DbClient.deleteData(query, params);
		
	}
	
		
	
	
}
