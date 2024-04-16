package com.vignesh.tradingApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.tradingApplication.model.UserTable;
import com.vignesh.tradingApplication.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public Iterable<UserTable> getAllUsers(){
		List<UserTable>list= repository.findAll();
		
		return list;
		
		
	}
	public  Optional<UserTable> getUserById(Integer id){
		return repository.findById(id);
		
	}
	public UserTable createUser(UserTable user) {
		return repository.save(user);
		
	}
	public String verify(String username, String email, String password) {
		
	Optional<UserTable> user=	repository.findByUsernameAndPassword(username,password);
	//System.out.println(user.getUsername()+" "+user.getPassword()+" "+user.getEmail());
	  if(user.isEmpty()) {
	  
	  return null;
	  }else {
		UserTable user1=  user.get();
		String user2=user1.getUsername();
		return user2;
	  }
//	if(!user.isEmpty()) {
//		 return "redirect:/Trading";
//	}else {
//		return "redirect:/Login";
//	}
	
		
	}
	
	public UserTable updateUser(Integer id,UserTable userDetails) throws UserNotFoundException {
		Optional<UserTable> userOptional=repository.findById(id);
		if(userOptional.isPresent()) {
			UserTable existingUser=userOptional.get();
			existingUser.setUsername(userDetails.getUsername());
			existingUser.setEmail(userDetails.getEmail());
			existingUser.setRole(userDetails.getRole());
			existingUser.setAccountBalance(userDetails.getAccountBalance());
			existingUser.setPassword(userDetails.getPassword());
			existingUser.setRegistrationDate(userDetails.getRegistrationDate());
			
			return repository.save(existingUser);
		}
		else {
			
			throw new UserNotFoundException("invalid id");
			
		}
		
		
		
	}
	public void deleteUser(Integer id) {
		repository.deleteById(id);
	}

}
