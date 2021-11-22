package dao;

public class Main {

	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();

		// imprimir usuarios
		for (User user : userDao.getAllUsers()) {
			System.out.println("Usuario -> login: " + user.getLogin() + ", email : " + user.getEmail());
		}

		// actualizar usuario
		User user = userDao.getAllUsers().get(0);
		user.setEmail("123@gmail.com");
		userDao.updateUser(user);

		// imprimir usuario
		userDao.getUser(0);
		System.out.println("Usuario -> login: " + user.getLogin() + ", email : " + user.getEmail());
	}

}
