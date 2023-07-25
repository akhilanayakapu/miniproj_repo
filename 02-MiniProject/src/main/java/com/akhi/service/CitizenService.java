package com.akhi.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.akhi.binding.CitizenPlan;
import com.akhi.binding.SearchRequest;

public interface CitizenService {
                public List<String> getPlanNames();
                public List<String> getPlanStatus();
                public List<CitizenPlan> getCitizenPlans(SearchRequest request);
                public void exportExcel(HttpServletResponse response);
                public void exportPdf(HttpServletResponse response);
                
	
	
	
	
}
