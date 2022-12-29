package com.ashok.service;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.ashok.entity.Customers;
import com.ashok.entity.SearchRequest;


public interface ReportService {
	
	public List<String> getPlaneName();
	public List<String> getPlaneStatuses();
	public List<Customers> getCustomers(SearchRequest request);
	public void exportExcel(HttpServletResponse response) throws Exception;
	public void exportPdf(HttpServletResponse response)throws Exception;

}
