package bookshelf.DAO;

import java.util.List;

import bookshelf.model.User;

public interface UserDao {

	public List<User> getUsers();
	
	public User getUser(Long id);
	
	public User saveUser(User user);
	
	public User updateUser(Long id, User user);
	
	public User deleteUser(Long id);
}
