package com.akhi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhi.binding.LoginForm;
import com.akhi.binding.UnlockAccountForm;
import com.akhi.binding.UserForm;
import com.akhi.entity.CityMaster;
import com.akhi.entity.CountryMaster;
import com.akhi.entity.StateMaster;
import com.akhi.entity.User;
import com.akhi.repository.CityRepository;
import com.akhi.repository.CountryRepository;
import com.akhi.repository.StateRepository;
import com.akhi.repository.UserRepository;
@Service
public class UserServiceImpl implements UserMgmtService{
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private CountryRepository countryrepo;
	
	@Autowired
	private StateRepository staterepo;
	
	@Autowired
	private CityRepository cityrepo;
	

	@Override
	public String checkMail(String email) {
		User findByEmail = userrepo.findByEmail(email);
		if(findByEmail==null) {
			return "UNIQUE";
		}
		return "DUPLICATE";
	}

	@Override
	public Map<Integer, String> getCountries() {
		List<CountryMaster> countries = countryrepo.findAll();
		Map<Integer,String> countrymap=new HashMap<>();
		countries.forEach(country->{countrymap.put(country.getCountryId(),country.getCountryName());
		});
		
		return countrymap;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {
		List<StateMaster> states = staterepo.findByCountryId(countryId);
		Map<Integer,String> statemap= new HashMap<>();
		states.forEach(state->{statemap.put(state.getStateId(), state.getStateName());
		});
		
		return statemap;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {
		List<CityMaster> cities = cityrepo.finfByStateId(stateId);
		Map<Integer,String> citimap=new HashMap<>();
		cities.forEach(citi->{citimap.put(citi.getCityId(), citi.getCityName());
	});
		return citimap;
	}

	@Override
	public String registerUser(UserForm userFrom) {
		//copy data from binding object to entity object
		User entity= new User();
		BeanUtils.copyProperties(userFrom, entity);
		//Generate & set random password
		
		entity.setUserPwd(generateRandomPwd());
		
		//set account status as locked
		entity.setAccStatus("LOCKED");
		
		userrepo.save(entity);
		//send email to unlock account
		return null;
	}

	@Override
	public String unlockAccount(UnlockAccountForm unlockAccnt) {
		String email = unlockAccnt.getEmail();
		User user = userrepo.findByEmail(email);
		if(user.getUserPwd().equals(unlockAccnt.getNewPwd())) {
		user.setUserPwd(unlockAccnt.getNewPwd());
		user.setAccStatus("UNLOCKED");
		userrepo.save(user);
		return "account unlocked";
		}
		return "invalid temporary password";
	}

	@Override
	public String Login(LoginForm loginForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String forgotPwd(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//to generate a random password
	private String generateRandomPwd() {
		String text="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder sb=new StringBuilder();
		Random random =new Random();
		int pwdLenght=6;
		
		for(int i=1;i<=pwdLenght;i++) {
			int nextInt = random.nextInt(text.length());
			sb.append(text.charAt(nextInt));
		}
		return sb.toString();
		
	}

}
