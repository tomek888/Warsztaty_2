package pl.coderslab.tomek888.bootcamp;


import java.sql.SQLException;

public class Init {
	
	
	public static void createDB(String db_name) { 
		
		String query = "Create Database "+db_name
						+" Default Charset utf8"
						+" Default Collate utf8_unicode_ci";
		
		DbClient.execute(query, new String[0]);
			
		
	}
	

	public static void createTables() throws Exception{
		
		if(DbClient.db_name.length() == 0) {
			throw new Exception("Not configured database name");
		}
		
		String[] query = new String[4];
		
		
		query[0]=
				"CREATE TABLE IF NOT EXISTS `user_group` ( " + 
				"  `id` INT NOT NULL AUTO_INCREMENT, " + 
				"  `name` VARCHAR(45) NULL, " + 
				"  PRIMARY KEY (`id`)) " + 
				"ENGINE = InnoDB; ";
		
		query[1]=
				" CREATE TABLE IF NOT EXISTS `users` ( " + 
				"  `id` BIGINT NOT NULL AUTO_INCREMENT, " + 
				"  `username` VARCHAR(255) NULL, " + 
				"  `email` VARCHAR(255) NULL, " + 
				"  `password` VARCHAR(255) NULL, " + 
				"  `person_group_id` INT, " + 
				"  PRIMARY KEY (`id`), " + 
				"  INDEX `fk_users_user_group_idx` (`person_group_id` ASC), " + 
				"  CONSTRAINT `fk_users_user_group` " + 
				"    FOREIGN KEY (`person_group_id`) " + 
				"    REFERENCES `user_group` (`id`) " + 
				"    ON DELETE NO ACTION " + 
				"    ON UPDATE NO ACTION) " + 
				"ENGINE = InnoDB; " ;
		query[2]=
				"CREATE TABLE IF NOT EXISTS `exercise` ( " + 
				"  `id` BIGINT NOT NULL AUTO_INCREMENT, " + 
				"  `title` VARCHAR(255) NULL, " + 
				"  `description` TEXT NULL, " + 
				"  PRIMARY KEY (`id`)) " + 
				"ENGINE = InnoDB; "; 
		query[3]=
				"CREATE TABLE IF NOT EXISTS `solution` ( " + 
				"  `id` BIGINT NOT NULL AUTO_INCREMENT, " + 
				"  `created` DATETIME NULL, " + 
				"  `updated` DATETIME NULL, " + 
				"  `description` TEXT NULL, " + 
				"  `users_id` BIGINT NOT NULL, " + 
				"  `exercise_id` BIGINT NOT NULL, " + 
				"  PRIMARY KEY (`id`), " + 
				"  INDEX `fk_solution_users1_idx` (`users_id` ASC), " + 
				"  INDEX `fk_solution_exercise1_idx` (`exercise_id` ASC), " + 
				"  CONSTRAINT `fk_solution_users1` " + 
				"    FOREIGN KEY (`users_id`) " + 
				"    REFERENCES `users` (`id`) " + 
				"    ON DELETE NO ACTION " + 
				"    ON UPDATE NO ACTION, " + 
				"  CONSTRAINT `fk_solution_exercise1` " + 
				"    FOREIGN KEY (`exercise_id`) " + 
				"    REFERENCES `exercise` (`id`) " + 
				"    ON DELETE NO ACTION " + 
				"    ON UPDATE NO ACTION) " + 
				"ENGINE = InnoDB; ";

		for (String q : query) { 
			DbClient.execute(q, new String[0]);
		}
		
		
		
	}
	
}











