package net.robotmodel67.juno.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.robotmodel67.juno.models.User;
import net.robotmodel67.juno.repos.UserRepository;

@RestController
@RequestMapping(path = "/resources/auth")
public class UserResource {

	@Autowired
	private UserRepository repository; 
	
	@GetMapping(path ="user")
	public List<User> list(){
		return repository.findAll(); 
	}
	
	@GetMapping(path = "user/{id}")
	public User getUserById(@PathVariable long id) {
		User user = repository.findById(id).get(); 
		return user;
	}

	@PostMapping(path = "user/search")
	public User getUserByUsernameAndPassword(@RequestBody User user) {
		User result = repository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		return result;
	}
	
/*	
	@PostMapping(path = "user/search/findByUsernameAndPassword")
	public User getUserByName(@RequestParam(value="username", required = false) String username,
			@RequestParam(value="password", required = false) String password) {
		//User user = repository.findByUsername(username);
		User user = repository.findByUsernameAndPassword(username, password);
		return user;
	}
*/	
	@PostMapping(path="user")
	public User create(@RequestBody User user) {
		User result = repository.saveAndFlush(user);
		return result;
	}
}
