package dao;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

	   //supongamos que nuestra lista es la bbdd
	   List<User> users;

	   //creamos los objetos
	   public UserDaoImpl(){
	      users = new ArrayList<User>();
	      User user1 = new User(1, "admin", "admin@gmail.com");
	      User user2 = new User(2, "usuario", "usuario@gmail.com");
	      users.add(user1);
	      users.add(user2);		
	   }


	   public void deleteUser(User user) {
	      users.remove(user.getId());
	      System.out.println("Usuario " + user.getLogin() + " ha sido borrado.");
	   }

	   public List<User> getAllUsers() {
	      return users;
	   }

	   public User getUser(int id) {
	      return users.get(id);
	   }

	   public void updateUser(User user) {
	      users.get(user.getId()).setEmail(user.getEmail());
	      System.out.println("Usuario " + user.getLogin() + " ha sido actualizado");
	   }

	   
}
