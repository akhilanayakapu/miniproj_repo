package com.akhi.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.akhi.binding.CitizenPlan;
import com.akhi.binding.SearchRequest;
import com.akhi.repository.CitizenRepo;

@Service
public class CitizenServiceImpl implements CitizenService {
	@Autowired
	private CitizenRepo planrepo;

	@Override
	public List<String> getPlanNames() {
		return planrepo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		return planrepo.getPlanStatus();
	}

	CitizenPlan entity = new CitizenPlan();

	@Override
	public List<CitizenPlan> getCitizenPlans(SearchRequest request) {
		if (request.getPlanName() != null && !request.getPlanName().equals("")) {
			entity.setPlanName(request.getPlanName());
		}
		if (request.getPlanStatus() != null && !request.getPlanStatus().equals("")) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		Example<CitizenPlan> example = Example.of(entity);
		List<CitizenPlan> findAll = planrepo.findAll(example);
		return findAll;
	}

	@Override
	public void exportExcel(HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exportPdf(HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
