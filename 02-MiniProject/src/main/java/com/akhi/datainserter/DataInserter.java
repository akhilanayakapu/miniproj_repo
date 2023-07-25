package com.akhi.datainserter;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.akhi.binding.CitizenPlan;
import com.akhi.repository.CitizenRepo;

@Component
public class DataInserter implements ApplicationRunner {
	@Autowired
	private CitizenRepo planrepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		CitizenPlan cp1 = new CitizenPlan();
		cp1.setCname("akhila");
		cp1.setGender("female");
		cp1.setPlanName("snap");
		cp1.setPlanStatus("approved");

		CitizenPlan cp2 = new CitizenPlan();
		cp2.setCname("aaa");
		cp2.setGender("female");
		cp2.setPlanName("abc");
		cp2.setPlanStatus("denial");

		CitizenPlan cp3 = new CitizenPlan();
		cp3.setCname("bbb");
		cp3.setGender("female");
		cp3.setPlanName("abc");
		cp3.setPlanStatus("denial");

		List<CitizenPlan> asList = Arrays.asList(cp1, cp2, cp3);
		planrepo.saveAll(asList);

	}

}
