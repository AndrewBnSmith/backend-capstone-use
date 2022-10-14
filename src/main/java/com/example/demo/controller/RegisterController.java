package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/")
public class RegisterController {
	
	@Autowired
	private UserRepository userRepository;

	//create
		@PostMapping("/register")
		public User registerUser(@RequestBody User user) throws Exception {
			String templEmail = user.getEmail();
			if(templEmail !=null && !"".equals(templEmail)) {
				User userObj = userRepository.findByEmail(templEmail);
				if(userObj != null) {
					throw new Exception("User with " + templEmail + " already exists");
				}
			}
			User userObj = null;
			userObj = userRepository.save(user);
			return userObj;
		}
		
		
		@PostMapping("/login")
		public User loginUser(@RequestBody User user) throws Exception {
			String tempEmail = user.getEmail();
			String tempPassword = user.getPassword();
			User userObj = null;
			if(tempEmail !=null && tempPassword !=null) {
				userObj = userRepository.findByEmailAndPassword(tempEmail, tempPassword);
			}
			if (userObj == null) {
				throw new Exception("Error to login");
			}
			return userObj;
		}
		
		// get all
		@GetMapping("/users")
		public List<User> getAllUsers(){
			return userRepository.findAll();
		}
				
		//get by id
		@GetMapping("/user/{id}")
		public ResponseEntity<User> getUserById(@PathVariable Long id) {
			User user = userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
			return ResponseEntity.ok(user);
		}
		
		//update
		@PutMapping("/userProfile/{id}")
		public ResponseEntity<User> updateUserInfo(@PathVariable Long id , @RequestBody User userDetails) {
			User user = userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
			user.setFirstName(userDetails.getFirstName());
			user.setLastName(userDetails.getLastName());
			user.setUsername(userDetails.getUsername());
			user.setJobTitle(userDetails.getJobTitle());
			user.setPhoneNumber(userDetails.getPhoneNumber());
			user.setEmail(userDetails.getEmail());
			user.setPassword(userDetails.getPassword());

			
			User updatedUser = userRepository.save(user);
			return ResponseEntity.ok(updatedUser);
		}
		
		//update pass
		@PutMapping("/userPassword/{id}")
		public ResponseEntity<User> updateUserPass(@PathVariable Long id , @RequestBody User userDetails) {
			User user = userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
			user.setPassword(userDetails.getPassword());
			
			User updatedUser = userRepository.save(user);
			return ResponseEntity.ok(updatedUser);
		}
		
}
