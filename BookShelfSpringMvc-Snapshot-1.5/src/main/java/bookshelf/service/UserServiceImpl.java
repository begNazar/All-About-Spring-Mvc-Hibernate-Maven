package bookshelf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bookshelf.DAO.UserDao;
import bookshelf.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	public List<User> getUsers() {
		System.out.println("\nthis is listing method from UserService.");
		return userDao.getUsers();
	}

	public User getUser(Long id) {
		System.out.println("\nthis is getUser method from UserService.");
		return userDao.getUser(id);
	}

	public User saveUser(User user) {
		System.out.println("\nthis is saveUser method from UserService.");
		return userDao.saveUser(user);
	}

	public User updateUser(Long id, User user) {
		System.out.println("\nthis is update method from UserService.");
		return userDao.updateUser(id, user);
	}

	public User deleteUser(Long id) {
		System.out.println("\nthis is delete method from UserService.");
		return userDao.deleteUser(id);
	}

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
