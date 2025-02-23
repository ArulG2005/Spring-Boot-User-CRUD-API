package com.logicfirst.CURD.Operations_Spring.Boot.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logicfirst.CURD.Operations_Spring.Boot.entity.UserEntity;
import com.logicfirst.CURD.Operations_Spring.Boot.models.User;
import com.logicfirst.CURD.Operations_Spring.Boot.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserRepository user;
	@GetMapping("getUsers")
	public List<UserEntity> getUsers(){
		return user.findAll();
	}
	@PostMapping("/new")
	public UserEntity CreateUser(@RequestBody UserEntity data) {
		return user.save(data);
	}
	@GetMapping("/getUser/{id}")
	public Optional<UserEntity> getUserById(@PathVariable Long id) {
		return user.findById(id);
	}
	
	@PutMapping("/edit/{id}")
	public UserEntity updateUser(@PathVariable Long id,@RequestBody UserEntity data) {
		Optional<UserEntity> u= user.findById(id);
		u.get().setName(data.getName());
		u.get().setEmail(data.getEmail());
		return user.save(u.get());
	}
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		user.deleteById(id);
		return "Deleted successfully";
	}
}
