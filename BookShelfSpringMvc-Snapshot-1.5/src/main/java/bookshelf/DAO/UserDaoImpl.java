package bookshelf.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import bookshelf.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

//	@Autowired
//	private SessionFactory sessionFactory;
	
	public List<User> getUsers() {
		System.out.println("\nthis is listing method from Userdao.");
		// 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();
	
		// create session
		Session currentSession = factory.getCurrentSession();

		// create a query  ... sort by last name
				
		try {
			User theUsers = new User();
			
			// start transaction
			currentSession.beginTransaction();
			
			//save the student object
		//	currentSession.get().getUsers();
			
			// commit transaction
			currentSession.getTransaction().commit();
			
			// create a person object
			System.out.println("Creating a new person object");			
			
			System.out.println("this is new record!");
			
			System.out.println(theUsers);

			} finally {
			
				
			}
			
		
		return null;
	}

	public User getUser(Long id) {
		System.out.println("\nthis is getUser method from Userdao.");
		return new User();
	}
	
	// User save method using hibernate technology
	public User saveUser(User user) {
		System.out.println("\nthis is saveUser method from Userdao.");
		
				// create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(User.class)
						.buildSessionFactory();

				// create session
				Session session = factory.getCurrentSession();

				try {
					
					// create a user object
					System.out.println("Creating a new student object");
					User tempUser = new User("beg", "NAZAROV", "beg@gmail.com", "beg123", "ADMIN");
							
					// start a transaction
					session.beginTransaction();

					// save the student object
					System.out.println("Saving the student...");
					session.save(tempUser);
					
					
					// commit transaction
					session.getTransaction().commit();

					System.out.println("Done!");
				} finally {

					factory.close();
				}

		
		return new User();
	}

	public User updateUser(Long id, User user) {
		System.out.println("\nthis is update method from Userdao.");
		return new User();
	}

	public User deleteUser(Long id) {
		System.out.println("\nthis is delete method from Userdao.");
		return null;
	}

}
