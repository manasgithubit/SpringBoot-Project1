package In.NIT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import In.NIT.Entity.User;
import In.NIT.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getallUser()
	{
		return userService.getallUsers();
	}
	
	@GetMapping("/user")
	public User getUserById(Integer id)
	{
		return userService.getUserById(id);
	}
	
	@PostMapping
	public User createUser(@RequestBody User user)
	{
		return userService.createUser(user);
	}
	
	@PutMapping("/user/{id}")
	public User updateUser(Integer id,@RequestBody User userDetails)
	{
		 return userService.updateUser(id, userDetails);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(Integer id)
	{
		 userService.deleteUser(id);
	}
}
