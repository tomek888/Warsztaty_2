package pl.coderslab.tomek888.bootcamp;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {

	
	private int id = 0;
	private String username;
	private String password;
	private String email;
	private int group_id;
	
	public User (String username, String password, String email,int group_id) {
		setUsername(username);
		setPassword(password);
		setEmail(email);
		setGroup_id(group_id);
	}
	
	public User () {
		
	}

	public String getUsername() {
		return username;
	}

	public User setUsername(String username) {
		this.username =  username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}
	
	
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}
	
	
	public int getGroup_id() {
		return group_id;
	}
	public User setGroup_id(int group_id) {
		this.group_id = group_id;
		return this;
	}
	public void saveToDB(int a) {
		if ( (this.id == 0)&&(a==0) ) {
			addToDB();
		}else {
			updateInDB(a);
		}
	}
	
	private void addToDB() {
		
		String query = "Insert into users Values (null, ?, ?, ?, ?);";
		String[] params = { getUsername(), getEmail(), getPassword(), Integer.toString(getGroup_id()) };
		int newId = DbClient.insertData(query, params);
		if(newId != 0) {
			setId(newId);
		}
		
	}
	
	private void updateInDB(int a) {
		
		String query = "Update users set username = ?, email = ?, password = ?, person_group_id = ? where id = ?";
		String[] params = {getUsername(), getEmail(), getPassword(), Integer.toString(getGroup_id()), Integer.toString(a) };
		
		DbClient.updateData(query, params);
		
	}
	
	
	public static User[] loadAll() {
		
		ArrayList<User> users = new ArrayList<User>();
		
		String query = "Select * from users;";
		
		try {
			ResultSet rs = DbClient.getData(query, new String[0]);
			
			while (rs.next()) {
				User tmpUser = new User(rs.getString(2), rs.getString(4), rs.getString(3), rs.getInt(5));
				tmpUser.id = rs.getInt(1);
				tmpUser.password = rs.getString(4);
				users.add(tmpUser);
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbClient.closeConnection();
		}
		
		
		User[] usersArr = new User[users.size()];
		usersArr = users.toArray(usersArr);
		
		return usersArr;
		
	}
	
	public static User loadOneById(int id) {
		
		
		String query = "Select * from users where id = ?;";
		String[] params = { Integer.toString(id) };
		
		User user = null;
		
		try {
			ResultSet rs = DbClient.getData(query, params);
			
			if (rs.next()) {
				user = new User(rs.getString(2), rs.getString(4), rs.getString(3),rs.getInt(5));
				user.id = rs.getInt(1);
				user.password = rs.getString(4);
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbClient.closeConnection();
		}
		
		return user;
		
	}
	
	public static void deleteById(int id) {
		
		String query = "Delete From users where id = ?";
		String[] params = { Integer.toString(id) };
		
		DbClient.deleteData(query, params);
		
	}
	public static User[] loadAllByGrupId(int id) {
		String query = "Select * from users JOIN user_group ON users.person_group_id=user_group.id where user_group.id = ?;";
		String[] params = { Integer.toString(id) };
		ArrayList<User> Users= new ArrayList<User>();
		
		
		
		try {
			ResultSet rs = DbClient.getData(query, params);
			
			while (rs.next()) {
				User tmpExercise = new User();
				tmpExercise.id = rs.getInt(1);
				tmpExercise.username = rs.getString(2);
				Users.add(tmpExercise);
			
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbClient.closeConnection();
		}
		
		
		User[] UsersArr = new User[Users.size()];
		UsersArr = Users.toArray(UsersArr);
		
		return UsersArr;
	}
		
	
	
}
