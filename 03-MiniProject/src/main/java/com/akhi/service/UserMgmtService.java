package com.akhi.service;

import java.util.Map;

import com.akhi.binding.LoginForm;
import com.akhi.binding.UnlockAccountForm;
import com.akhi.binding.UserForm;

public interface UserMgmtService {

	public String checkMail(String email);
	
	public Map<Integer,String> getCountries();
	
	public Map<Integer,String> getStates(Integer countryId);
	
	public Map<Integer,String> getCities(Integer stateId);
	
	public String registerUser(UserForm userFrom);
	
	public String unlockAccount(UnlockAccountForm accForm);
	
	public String Login(LoginForm loginForm);
	
	public String forgotPwd(String email);
	
}
