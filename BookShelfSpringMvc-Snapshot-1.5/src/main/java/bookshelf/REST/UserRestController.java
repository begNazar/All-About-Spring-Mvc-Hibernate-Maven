package bookshelf.REST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bookshelf.model.User;
import bookshelf.service.UserService;


@RestController
@RequestMapping("/api")
public class UserRestController {

//	User user = new User("Beg", "NAZAROV", "beg@gmail.com", "beg123","ADMIN");
	User user = new User();
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	// get list users
	@GetMapping("/users")
	public List<User> getUsers() {
		
		List<User> list = new ArrayList<User>();
		list.add(user);
		System.out.println(user);
		return userService.getUsers();
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable long id) {
		
		return userService.getUser(id);
	}
	
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		
		return userService.saveUser(user);
	}
	
	
	// update user
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return user;
	}
	
	// delete user
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
			
	}
		
	
}
