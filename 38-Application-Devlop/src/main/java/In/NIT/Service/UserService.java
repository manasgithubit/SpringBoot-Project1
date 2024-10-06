package In.NIT.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import In.NIT.Entity.User;
import In.NIT.Repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getallUsers()
	{
		return userRepository.findAll();
	}
	
	public User getUserById(Integer id)
	{
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")) ;
	}
	
	public User createUser(User user)
	{
		return userRepository.save(user);
	}
	
	public User updateUser(Integer id, User userDetails)
	{
		User user = getUserById(id);
		user.setId(userDetails.getId());
		user.setFirstname(userDetails.getFirstname());
		user.setLastname(userDetails.getLastname());
		user.setPhonenum(userDetails.getPhonenum());
		user.setAddress(userDetails.getAddress());
		return userRepository.save(user);
	}
	
	public void deleteUser(Integer id)
	{
		userRepository.deleteById(id);
	}
}
