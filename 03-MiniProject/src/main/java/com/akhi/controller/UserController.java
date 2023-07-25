package com.akhi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akhi.binding.LoginForm;
import com.akhi.binding.UnlockAccountForm;
import com.akhi.binding.UserForm;
import com.akhi.service.UserMgmtService;

@RestController
public class UserController {
	@Autowired
        private UserMgmtService userservice;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginForm loginForm){
		String login = userservice.Login(loginForm);
		return new ResponseEntity<>(login,HttpStatus.OK);
	}
	
	@GetMapping("/countries")
	public Map<Integer,String> getCountries(){
	return	userservice.getCountries();
	}
	
	@GetMapping("/states/{countryId}")
	public Map<Integer,String> getStates(@PathVariable Integer countryId){
		return  userservice.getStates(countryId);
	}
	
	@GetMapping("/cities/{stateId}")
	public Map<Integer,String> getCities(@PathVariable Integer stateId){
		return userservice.getCities(stateId);
	}
	@GetMapping("/email/{email}")
	public String checkEmail(String email) {
		return userservice.checkMail(email);
	}
      @PostMapping("/user")
	 public ResponseEntity<String> userRegister(@RequestBody UserForm userForm){
    	  String registerUser = userservice.registerUser(userForm);
    	  return new ResponseEntity<>(registerUser,HttpStatus.OK);
	 }
	@PostMapping("/unlock")
      public ResponseEntity<String> unlockAccount(@RequestBody UnlockAccountForm accForm) {
    	  String unlockAccount = userservice.unlockAccount(accForm);
    	  return new ResponseEntity<>(unlockAccount,HttpStatus.OK);
      }
	@GetMapping("/forgotPassword/email")
	public ResponseEntity<String> forgotPwd(@PathVariable String email) {
		String forgotPwd = userservice.forgotPwd(email);
	return	 new ResponseEntity<>(forgotPwd,HttpStatus.OK);
	}
	
}
