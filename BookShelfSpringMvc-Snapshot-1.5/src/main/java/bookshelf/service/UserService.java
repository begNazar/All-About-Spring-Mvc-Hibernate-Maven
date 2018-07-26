package bookshelf.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import bookshelf.model.User;

public interface UserService  extends UserDetailsService {

	
	
	public List<User> getUsers();
	
	public User getUser(Long id);
	
	public User saveUser(User user);
	
	public User updateUser(Long id, User user);
	
	public User deleteUser(Long id);

	User findByUserName(String userName);
	
}
